package com.tsdproject.pokerplanning.service.receivers

interface KickParticipantReceiver {
    fun onKickParticipantSuccess()

    fun onKickParticipantError()
}