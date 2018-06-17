package com.tsdproject.pokerplanning.participants

import android.content.Intent
import com.tsdproject.pokerplanning.model.IntentKeys
import com.tsdproject.pokerplanning.model.transportobjects.UserTO
import com.tsdproject.pokerplanning.service.ServiceManager
import com.tsdproject.pokerplanning.service.receivers.GetParticipantsReceiver
import java.util.*
import kotlin.concurrent.schedule

class ParticipantsPresenterImpl(var view: ParticipantsView) : ParticipantsPresenter, GetParticipantsReceiver {

    private var tableId: String? = null
    private var timerGetParticipant = Timer()
    private var shouldRefreshParticipants = true

    override fun initExtras(intent: Intent) {
        tableId = intent.getSerializableExtra(IntentKeys.TABLE_ID) as? String
    }

    override fun setupTableIdView() {
        view.setupTableIdView(tableId)
    }

    override fun getParticipants() {
        ServiceManager.getParticipants(this)
    }

    override fun onGetParticipantsError() {
        view.showGetParticipantsErrorToast()
        getParticipantsAfterDelay()
    }

    override fun onGetParticipantsSuccess(users: List<UserTO>) {
        view.updateParticipantsList(users)
        getParticipantsAfterDelay()
    }

    private fun getParticipantsAfterDelay() {
        timerGetParticipant.schedule(
            3000,
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
