package com.tsdproject.pokerplanning.service.receivers

interface LoginReceiver {
    fun onLoginSuccess(token: String)

    fun onLoginError(error: String?)
}