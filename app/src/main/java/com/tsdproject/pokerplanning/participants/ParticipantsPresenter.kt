package com.tsdproject.pokerplanning.participants

import com.tsdproject.pokerplanning.base.BasePresenter

interface ParticipantsPresenter : BasePresenter {
    val isRoomCreator: Boolean
    fun setupTableIdView()
    fun getParticipants()
    fun stopGetParticipants()
    fun setupStartGameButton()
    fun setUserReadyStatus(checked: Boolean)
    fun startGame()
}
