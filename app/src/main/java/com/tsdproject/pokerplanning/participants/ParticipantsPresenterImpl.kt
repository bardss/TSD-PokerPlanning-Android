package com.tsdproject.pokerplanning.participants

import android.content.Intent
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.model.IntentKeys
import com.tsdproject.pokerplanning.model.transportobjects.UserTO
import com.tsdproject.pokerplanning.model.utils.ResUtil
import com.tsdproject.pokerplanning.service.ServiceManager
import com.tsdproject.pokerplanning.service.receivers.GetParticipantsReceiver
import com.tsdproject.pokerplanning.service.receivers.IsGameStartedReceiver
import com.tsdproject.pokerplanning.service.receivers.SetReadyStatusReceiver
import com.tsdproject.pokerplanning.service.receivers.StartGameReceiver
import java.util.*
import kotlin.concurrent.schedule

class ParticipantsPresenterImpl(var view: ParticipantsView) : ParticipantsPresenter,
    GetParticipantsReceiver, SetReadyStatusReceiver, StartGameReceiver, IsGameStartedReceiver {

    private var tableId: String? = null
    override var isRoomCreator: Boolean = false
    private var timerGetParticipant = Timer()
    private var shouldRefreshParticipants = true
    private var refreshParticipantsPeriod: Long = 3000

    override fun initExtras(intent: Intent) {
        tableId = intent.getSerializableExtra(IntentKeys.TABLE_ID) as? String
        isRoomCreator = intent.getBooleanExtra(IntentKeys.IS_ROOM_CREATOR, false)
    }

    override fun setupStartGameButton() {
        if (isRoomCreator) {
            view.showButtonForTableOwner()
        }
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
        view.showToast(ResUtil.getString(R.string.cannot_download_participants_list))
        getParticipantsAfterDelay()
    }

    override fun onGetParticipantsSuccess(users: List<UserTO>) {
        view.updateParticipantsList(users)
        getParticipantsAfterDelay()
    }

    override fun onSetReadyStatusError() {
        view.switchBackReadyStatus()
        view.showToast(ResUtil.getString(R.string.cannot_change_ready_status))
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

    override fun onIsGameStartedSuccess() {
        view.switchBackReadyStatus()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
