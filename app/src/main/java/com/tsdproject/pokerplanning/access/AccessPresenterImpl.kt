package com.tsdproject.pokerplanning.access

import android.content.Intent
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.database.LocalDatabase
import com.tsdproject.pokerplanning.model.transportobjects.UserLoginTO
import com.tsdproject.pokerplanning.model.utils.ResUtil
import com.tsdproject.pokerplanning.service.ServiceManager
import com.tsdproject.pokerplanning.service.receivers.LoginReceiver

class AccessPresenterImpl(var view: AccessView) : AccessPresenter, LoginReceiver {

    override fun initExtras(intent: Intent) {
    }

    override fun login(login: String, password: String) {
        view.startProgressDialog(ResUtil.getString(R.string.progress_loading_text))
        val userLogin = UserLoginTO(login, password)
        ServiceManager.login(userLogin, this)
    }

    override fun onLoginSuccess(token: String) {
        LocalDatabase.putUserToken(token)
        saveLoginToDatabase()
        view.clearEditTexts()
        view.stopProgressDialog()
        view.navigateToCreateRoom()
    }

    private fun saveLoginToDatabase() {
        val email = view.getUserLogin()
        LocalDatabase.putUserLogin(email)
    }

    override fun setSavedEmail() {
        val email = LocalDatabase.getUserLogin()
        email?.let {
            view.setSavedEmail(email)
        }
    }

    override fun onLoginError(error: String?) {
        error?.let {
            view.showToast(error)
        }
        view.setInputErrors()
        view.stopProgressDialog()
    }
}
