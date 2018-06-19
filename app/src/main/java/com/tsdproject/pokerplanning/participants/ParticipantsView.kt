package com.tsdproject.pokerplanning.participants

import com.tsdproject.pokerplanning.base.BaseView
import com.tsdproject.pokerplanning.model.transportobjects.UserTO

interface ParticipantsView: BaseView {

    fun setupTableIdView(tableId: String?)
    fun showGetParticipantsErrorToast()
    fun updateParticipantsList(users: List<UserTO>)
    fun showSetReadyErrorToast()
}
