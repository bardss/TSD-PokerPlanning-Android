package com.tsdproject.pokerplanning.splash

import com.tsdproject.pokerplanning.base.BaseView

interface SplashView: BaseView {

    fun setupNextViewDelay()
    fun showAddressErrorToast()
}
