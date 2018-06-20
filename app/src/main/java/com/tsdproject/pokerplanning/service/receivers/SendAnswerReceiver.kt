package com.tsdproject.pokerplanning.service.receivers

interface SendAnswerReceiver {

    fun onSendAnswerSuccess()

    fun onSendAnswerError()
}