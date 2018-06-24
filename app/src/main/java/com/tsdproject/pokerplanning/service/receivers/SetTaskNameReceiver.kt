package com.tsdproject.pokerplanning.service.receivers


interface SetTaskNameReceiver {
    fun onSetTaskNameSuccess()

    fun onSetTaskNameError()
}