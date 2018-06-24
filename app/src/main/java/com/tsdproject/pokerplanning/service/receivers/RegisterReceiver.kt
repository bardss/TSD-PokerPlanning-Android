package com.tsdproject.pokerplanning.service.receivers

interface RegisterReceiver {
    fun onRegisterSuccess()

    fun onRegisterError()
}