package com.tsdproject.pokerplanning.service.receivers

import com.tsdproject.pokerplanning.model.transportobjects.UserTO

interface GetParticipantsReceiver {
    fun onGetParticipantsSuccess(users: List<UserTO>)

    fun onGetParticipantsError()
}