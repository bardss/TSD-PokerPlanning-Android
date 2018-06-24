package com.tsdproject.pokerplanning.cards

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.azoft.carousellayoutmanager.CarouselLayoutManager
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.model.utils.ResUtil
import com.tsdproject.pokerplanning.service.ServiceManager
import com.tsdproject.pokerplanning.service.receivers.IsGameFinishedReceiver
import com.tsdproject.pokerplanning.service.receivers.SendAnswerReceiver
import com.tsdproject.pokerplanning.service.receivers.SetGameReadyStatusReceiver
import java.util.*
import kotlin.concurrent.schedule

class CardsPresenterImpl(var view: CardsView) : CardsPresenter,
    SendAnswerReceiver, SetGameReadyStatusReceiver, IsGameFinishedReceiver {

    override var canScrollHorizontally: Boolean = true
    private var timerGetParticipant = Timer()
    private var refreshParticipantsPeriod: Long = 3000

    override fun initExtras(intent: Intent) {
    }

    override fun getCarouselLayoutManager(): RecyclerView.LayoutManager {
        val layoutManager =
            object : CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, false) {
                override fun canScrollHorizontally(): Boolean {
                    return canScrollHorizontally
                }
            }
        layoutManager.setPostLayoutListener(CarouselZoomPostLayoutListener())
        layoutManager.maxVisibleItems = 15
        layoutManager.addOnItemSelectionListener({ adapterPosition ->
            val cardsAdapter = (view as CardsActivity).cardsAdapter
            val selectedCard = layoutManager.findViewByPosition(adapterPosition)
            cardsAdapter.setupCardClickability(selectedCard, true)

            val previousSelectedPosition = cardsAdapter.getPreviousSelectedPosition()
            if (previousSelectedPosition != null) {
                val previousCard: View? =
                    layoutManager.findViewByPosition(previousSelectedPosition)
                cardsAdapter.setupCardClickability(previousCard, false)
            }
            cardsAdapter.changePreviousCardPosition(adapterPosition)
        })
        return layoutManager
    }

    override fun setGameReadyStatus(isReady: Boolean){
        ServiceManager.setGameReadyStatus(this, isReady)
    }

    override fun sendAnswer(cardValue: String){
        ServiceManager.sendAnswer(this, cardValue)
    }

    private fun checkIfGameIsFinished(){
        ServiceManager.isGameFinished(this)
    }

    private fun checkIfGameFinishedAfterDelay() {
        timerGetParticipant.schedule(
            refreshParticipantsPeriod,
            {
                if (view.isReady()) {
                    checkIfGameIsFinished()
                }
            }
        )
    }

    override fun onSetGameReadyStatusError() {
        view.showToast(ResUtil.getString(R.string.cannot_change_ready_status))
    }

    override fun onSetGameReadyStatusSuccess() {
        if (view.isReady()) {
            checkIfGameFinishedAfterDelay()
        }
    }

    override fun onSendAnswerSuccess() {
    }

    override fun onSendAnswerError() {
        view.showToast(ResUtil.getString(R.string.cannot_send_answer))
    }

    override fun onIsGameFinishedSuccess(isFinished: Boolean?) {
        if (isFinished == true) {
            view.navigateToResults()
        }
    }

    override fun onIsGameFinishedError() {
        view.showToast(ResUtil.getString(R.string.cannot_check_if_game_is_finished))
    }
}
