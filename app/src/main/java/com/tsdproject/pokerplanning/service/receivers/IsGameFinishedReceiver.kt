package com.tsdproject.pokerplanning.service.receivers

interface IsGameFinishedReceiver {
    fun onIsGameFinishedSuccess(isFinished: Boolean?)

    fun onIsGameFinishedError()
}