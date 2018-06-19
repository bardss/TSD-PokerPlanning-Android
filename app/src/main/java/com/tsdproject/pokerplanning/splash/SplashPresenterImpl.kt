package com.tsdproject.pokerplanning.splash

import android.content.Intent
import android.os.Handler
import com.tsdproject.pokerplanning.service.ServiceManager
import com.tsdproject.pokerplanning.service.ServiceProvider
import com.tsdproject.pokerplanning.service.receivers.DynamicAddressReceiver

class SplashPresenterImpl(var view: SplashView) : SplashPresenter, DynamicAddressReceiver {

    override fun initExtras(intent: Intent) {
    }

    override fun handleSplashScreen(startActivityFunction: () -> Unit) {
        Handler().postDelayed(startActivityFunction, 1500)
    }

    override fun getDynamicAddress() {
        ServiceManager.getDynamicAddress(this)
    }

    override fun onGetDynamicAddressError() {
        view.showAddressErrorToast()
    }

    override fun onGetDynamicAddressSuccess(dynamicAddress: String) {
        setupServiceEndpoint(dynamicAddress)
        view.setupNextViewDelay()
    }

    private fun setupServiceEndpoint(dynamicAddress: String) {
        ServiceProvider.SERVICE_ENDPOINT = "http://$dynamicAddress/api/"
    }
}
