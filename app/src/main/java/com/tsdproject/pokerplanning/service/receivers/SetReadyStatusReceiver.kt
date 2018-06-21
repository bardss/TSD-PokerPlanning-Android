package com.tsdproject.pokerplanning.service.receivers

interface SetReadyStatusReceiver {
    fun onSetReadyStatusSuccess()

    fun onSetReadyStatusError()
}