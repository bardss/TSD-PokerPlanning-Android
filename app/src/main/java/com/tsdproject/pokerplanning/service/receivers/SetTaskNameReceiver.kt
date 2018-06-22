package com.tsdproject.pokerplanning.service.receivers


interface SetTaskNameReceiver {
    fun onSetReadyStatusSuccess()

    fun onSetReadyStatusError()
}