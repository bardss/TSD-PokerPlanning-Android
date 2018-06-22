package com.tsdproject.pokerplanning.participants

import android.content.Intent
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.model.IntentKeys
import com.tsdproject.pokerplanning.model.transportobjects.ParticipantsTO
import com.tsdproject.pokerplanning.model.transportobjects.UserTO
import com.tsdproject.pokerplanning.model.utils.ResUtil
import com.tsdproject.pokerplanning.service.ServiceManager
import com.tsdproject.pokerplanning.service.receivers.*
import java.util.*
import kotlin.concurrent.schedule

class ParticipantsPresenterImpl(var view: ParticipantsView) : ParticipantsPresenter,
    GetParticipantsReceiver, SetReadyStatusReceiver, StartGameReceiver, IsGameStartedReceiver, KickParticipantReceiver,
    SetTaskNameReceiver {

    private var tableId: String? = null
    override var isRoomCreator: Boolean = false
    private var timerGetParticipant = Timer()
    private var shouldRefreshParticipants = true
    private var refreshParticipantsPeriod: Long = 3000

    override fun initExtras(intent: Intent) {
        tableId = intent.getSerializableExtra(IntentKeys.TABLE_ID) as? String
        isRoomCreator = intent.getBooleanExtra(IntentKeys.IS_ROOM_CREATOR, false)
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

    override fun kickParticipant(email: String) {
        view.startProgressDialog(ResUtil.getString(R.string.progress_loading_text))
        ServiceManager.kickParticipant(this, email)
    }

    override fun onGetParticipantsError() {
        view.showToast(ResUtil.getString(R.string.cannot_download_participants_list))
        getParticipantsAfterDelay()
    }

    override fun onGetParticipantsSuccess(participantsTO: ParticipantsTO) {
        view.updateParticipantsList(participantsTO.participants)
        view.updateTaskName(participantsTO.taskName)
        getParticipantsAfterDelay()
    }

    override fun onSetReadyStatusError() {
        view.switchBackReadyStatus()
        view.showToast(ResUtil.getString(R.string.cannot_change_ready_status))
    }

    override fun onSetReadyStatusSuccess() {
    }

    private fun getParticipantsAfterDelay() {
        timerGetParticipant.schedule(
            refreshParticipantsPeriod,
            {
                if (shouldRefreshParticipants) {
                    getParticipants()
                }
                if (view.isReady() && !isRoomCreator) {
                    checkIfGameStarted()
                }
            })
    }

    private fun checkIfGameStarted() {
        ServiceManager.isGameStarted(this)
    }

    override fun stopGetParticipants() {
        shouldRefreshParticipants = false
    }

    override fun startGame() {
        view.startProgressDialog(ResUtil.getString(R.string.progress_loading_text))
        ServiceManager.startGame(this)
    }

    override fun onStartGameSuccess() {
        view.stopProgressDialog()
        view.navigateToCardsActivity()
    }

    override fun onStartGameError() {
        view.showToast(ResUtil.getString(R.string.not_all_users_are_ready))
        view.stopProgressDialog()
    }

    override fun onIsGameStartedError() {
        view.showToast(ResUtil.getString(R.string.cannot_check_game_status))
    }

    override fun onIsGameStartedSuccess(isStarted: Boolean?) {
        if (isStarted == true) {
            view.switchBackReadyStatus()
            view.navigateToCardsActivity()
        }
    }

    override fun onKickParticipantError() {
        view.stopProgressDialog()
        view.showToast(ResUtil.getString(R.string.cannot_kick_participant))
    }

    override fun onKickParticipantSuccess() {
        view.stopProgressDialog()
    }

    override fun setTaskName(taskName: String) {
        view.startProgressDialog(ResUtil.getString(R.string.progress_loading_text))
        ServiceManager.setEstimationTaskName(this, taskName)
    }

    override fun onSetTaskNameSuccess() {
        view.hideTaskNameDialog()
        view.stopProgressDialog()
    }

    override fun onSetTaskNameError() {
        view.showToast(ResUtil.getString(R.string.can_not_set_task_name))
        view.stopProgressDialog()
    }
}
