package com.tsdproject.pokerplanning.service.receivers

interface RegisterReceiver {
    fun onRegisterSuccess(token: String)

    fun onRegisterError()
}