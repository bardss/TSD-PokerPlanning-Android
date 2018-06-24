package com.tsdproject.pokerplanning.service.receivers

interface SetGameReadyStatusReceiver {
    fun onSetGameReadyStatusSuccess()

    fun onSetGameReadyStatusError()
}