package com.tsdproject.pokerplanning.service.receivers

import com.tsdproject.pokerplanning.model.transportobjects.ParticipantsTO
import com.tsdproject.pokerplanning.model.transportobjects.UserTO

interface GetParticipantsReceiver {
    fun onGetParticipantsSuccess(participantsTO: ParticipantsTO)

    fun onGetParticipantsError()
}