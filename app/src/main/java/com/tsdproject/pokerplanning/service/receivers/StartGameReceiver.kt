package com.tsdproject.pokerplanning.service.receivers

interface StartGameReceiver {
    fun onStartGameSuccess()

    fun onStartGameError()
}