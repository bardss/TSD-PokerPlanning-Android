package com.tsdproject.pokerplanning.registration

import android.content.Intent
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.model.transportobjects.AddUserTO
import com.tsdproject.pokerplanning.model.utils.ResUtil
import com.tsdproject.pokerplanning.service.ServiceManager
import com.tsdproject.pokerplanning.service.receivers.RegisterReceiver

class RegistrationPresenterImpl(var view: RegistrationView) : RegistrationPresenter, RegisterReceiver {

    override fun initExtras(intent: Intent) {
    }

    override fun registerUser(addUser: AddUserTO) {
        view.startProgressDialog(ResUtil.getString(R.string.progress_loading_text))
        ServiceManager.register(addUser, this)
    }

    override fun onRegisterError() {
        view.stopProgressDialog()
    }

    override fun onRegisterSuccess() {
        view.showSuccessToast()
        view.stopProgressDialog()
        view.navigateToAccess()
    }
}
