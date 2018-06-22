package com.tsdproject.pokerplanning.participants

import com.tsdproject.pokerplanning.base.BaseView
import com.tsdproject.pokerplanning.model.transportobjects.UserTO

interface ParticipantsView : BaseView {
    fun isReady(): Boolean
    fun setupTableIdView(tableId: String?)
    fun updateParticipantsList(users: List<UserTO>)
    fun navigateToCardsActivity()
    fun switchBackReadyStatus()
    fun kickParticipant(email: String)
    fun hideTaskNameDialog()
}
