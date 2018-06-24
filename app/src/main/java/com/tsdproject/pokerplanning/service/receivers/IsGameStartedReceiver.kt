package com.tsdproject.pokerplanning.service.receivers

interface IsGameStartedReceiver {
    fun onIsGameStartedSuccess(isStarted: Boolean?)

    fun onIsGameStartedError()
}