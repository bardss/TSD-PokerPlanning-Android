package com.tsdproject.pokerplanning.participants

import com.tsdproject.pokerplanning.base.BasePresenter

interface ParticipantsPresenter: BasePresenter {
    fun setupTableIdView()
    fun getParticipants()
    fun stopGetParticipants()
}
