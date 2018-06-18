package com.tsdproject.pokerplanning.service

import android.widget.Toast
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.base.ApplicationContext
import com.tsdproject.pokerplanning.database.LocalDatabase
import com.tsdproject.pokerplanning.model.transportobjects.AddUserTO
import com.tsdproject.pokerplanning.model.transportobjects.TokenTO
import com.tsdproject.pokerplanning.model.transportobjects.UserLoginTO
import com.tsdproject.pokerplanning.model.transportobjects.UserTableToken
import com.tsdproject.pokerplanning.model.utils.ResUtil
import com.tsdproject.pokerplanning.model.utils.ToastUtil
import com.tsdproject.pokerplanning.service.receivers.*
import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action0
import rx.functions.Action1
import rx.schedulers.Schedulers
import timber.log.Timber

object ServiceManager {

    fun login(userLogin: UserLoginTO, receiver: LoginReceiver) {
        setupRequest(ServiceProvider
                .usersService
                .login(userLogin),
                Action1 {
                    receiver.onLoginSuccess(it as String)
                },
                Action1 { e ->
                    handleError()
                    receiver.onLoginError()
                },
                Action0 {
                    Timber.e("login completed")
                })
    }

    fun register(addUser: AddUserTO, receiver: RegisterReceiver) {
        setupRequest(ServiceProvider
                .usersService
                .register(addUser),
                Action1 {
                    receiver.onRegisterSuccess()
                },
                Action1 { e ->
                    handleError()
                    receiver.onRegisterError()
                },
                Action0 {
                    Timber.e("register completed")
                })
    }

    fun getDynamicAddress(receiver: DynamicAddressReceiver) {
        setupRequest(ServiceProvider
            .dynamicAddressService
            .getDynamicAddress(),
            Action1 {
                receiver.onGetDynamicAddressSuccess(it as String)
            },
            Action1 { e ->
                handleError()
                receiver.onGetDynamicAddressError()
            },
            Action0 {
                Timber.e("get dynamic address completed")
            })
    }

    fun createTable(receiver: CreateTableReceiver) {
        setupRequest(ServiceProvider
            .playTablesService
            .createTable(TokenTO(LocalDatabase.getUserToken())),
            Action1 {
                receiver.onCreateTableSuccess(it as String)
            },
            Action1 { e ->
                handleError()
                receiver.onCreateTableError()
            },
            Action0 {
                Timber.e("get dynamic address completed")
            })
    }


    fun joinTable(receiver: JoinTableReceiver, userTableToken: UserTableToken) {
        setupRequest(ServiceProvider
            .playTablesService
            .joinTable(userTableToken),
            Action1 {
                receiver.onJoinTableSuccess()
            },
            Action1 { e ->
                handleError()
                receiver.onJoinTableError()
            },
            Action0 {
                Timber.e("get dynamic address completed")
            })
    }

    private fun setupRequest(
            observable: Observable<*>,
            onNext: Action1<Any>,
            onError: Action1<Throwable>,
            onCompleted: Action0
    ): Subscription {
        return observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError, onCompleted)
    }

    private fun handleError() {
        val context = ApplicationContext.appContext
        ToastUtil.show(
                context,
                ResUtil.getString(R.string.something_went_wrong),
                Toast.LENGTH_LONG
        )
    }

}