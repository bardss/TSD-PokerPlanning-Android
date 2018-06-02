package com.tsdproject.pokerplanning.registration

import android.content.Intent
import com.tsdproject.pokerplanning.service.receivers.RegisterReceiver


class RegistrationPresenterImpl(var view: RegistrationView) : RegistrationPresenter, RegisterReceiver {


    override fun initExtras(intent: Intent) {
    }

    override fun onRegisterError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRegisterSuccess(token: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
