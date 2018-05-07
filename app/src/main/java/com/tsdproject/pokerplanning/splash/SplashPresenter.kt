package com.tsdproject.pokerplanning.splash

import com.tsdproject.pokerplanning.base.BasePresenter

interface SplashPresenter: BasePresenter {

    fun handleSplashScreen(startActivityFunction: () -> Unit)

}
