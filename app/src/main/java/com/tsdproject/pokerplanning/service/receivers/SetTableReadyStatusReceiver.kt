package com.tsdproject.pokerplanning.service.receivers

interface SetTableReadyStatusReceiver {
    fun onSetTableReadyStatusSuccess()

    fun onSetTableReadyStatusError()
}