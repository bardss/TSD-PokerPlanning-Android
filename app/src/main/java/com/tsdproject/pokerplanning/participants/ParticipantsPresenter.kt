package com.tsdproject.pokerplanning.participants

import com.tsdproject.pokerplanning.base.BasePresenter

interface ParticipantsPresenter : BasePresenter {
    val isRoomCreator: Boolean
    fun setupTableIdView()
    fun getParticipants()
    fun setShouldDoRequests(shouldDoRequests: Boolean)
    fun setUserReadyStatus(checked: Boolean)
    fun startGame()
    fun kickParticipant(email: String)
    fun setTaskName(taskName: String)
}
