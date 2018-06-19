package com.tsdproject.pokerplanning.participants

import android.content.Intent
import com.tsdproject.pokerplanning.model.IntentKeys
import com.tsdproject.pokerplanning.model.transportobjects.UserTO
import com.tsdproject.pokerplanning.service.ServiceManager
import com.tsdproject.pokerplanning.service.receivers.GetParticipantsReceiver
import com.tsdproject.pokerplanning.service.receivers.SetReadyStatusReceiver
import java.util.*
import kotlin.concurrent.schedule

class ParticipantsPresenterImpl(var view: ParticipantsView) : ParticipantsPresenter,
    GetParticipantsReceiver, SetReadyStatusReceiver {

    private var tableId: String? = null
    private var timerGetParticipant = Timer()
    private var shouldRefreshParticipants = true
    private var refreshParticipantsPeriod: Long = 3000

    override fun initExtras(intent: Intent) {
        tableId = intent.getSerializableExtra(IntentKeys.TABLE_ID) as? String
    }

    override fun setupTableIdView() {
        view.setupTableIdView(tableId)
    }

    override fun getParticipants() {
        ServiceManager.getParticipants(this)
    }

    override fun setUserReadyStatus(checked: Boolean) {
        ServiceManager.setReadyStatus(checked, this)
    }

    override fun onGetParticipantsError() {
        view.showGetParticipantsErrorToast()
        getParticipantsAfterDelay()
    }

    override fun onGetParticipantsSuccess(users: List<UserTO>) {
        view.updateParticipantsList(users)
        getParticipantsAfterDelay()
    }

    override fun onSetReadyStatusError() {
        view.showSetReadyErrorToast()
    }

    override fun onSetReadyStatusSuccess() {
        // TODO: Check if game is started
    }

    private fun getParticipantsAfterDelay() {
        timerGetParticipant.schedule(
            refreshParticipantsPeriod,
            {
                if (shouldRefreshParticipants) {
                    getParticipants()
                }
            })
    }

    override fun stopGetParticipants() {
        shouldRefreshParticipants = false
    }
}
