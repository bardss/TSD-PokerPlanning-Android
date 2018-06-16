package com.tsdproject.pokerplanning.service.receivers


interface JoinTableReceiver {
    fun onJoinTableSuccess()

    fun onJoinTableError()
}