package com.tsdproject.pokerplanning.service.receivers

interface IsGameStartedReceiver {
    fun onIsGameStartedSuccess()

    fun onIsGameStartedError()
}