package com.tsdproject.pokerplanning.cards

import android.content.Intent
import android.support.v7.widget.RecyclerView
import com.azoft.carousellayoutmanager.CarouselLayoutManager
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.model.utils.ResUtil
import com.tsdproject.pokerplanning.service.ServiceManager
import com.tsdproject.pokerplanning.service.receivers.SendAnswerReceiver
import com.tsdproject.pokerplanning.service.receivers.SetGameReadyStatusReceiver

class CardsPresenterImpl(var view: CardsView) : CardsPresenter,
    SendAnswerReceiver, SetGameReadyStatusReceiver {

    override var canScrollHorizontally: Boolean = true

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
        return layoutManager
    }

    override fun setGameReadyStatus(isReady: Boolean){
        ServiceManager.setGameReadyStatus(this, isReady)
    }

    override fun sendAnswer(cardValue: String){
        ServiceManager.sendAnswer(this, cardValue)
    }

    override fun onSetGameReadyStatusError() {
        view.showToast(ResUtil.getString(R.string.cannot_change_ready_status))
    }

    override fun onSetGameReadyStatusSuccess() {
        // TODO: implement isFinished flow
    }

    override fun onSendAnswerSuccess() {
    }

    override fun onSendAnswerError() {
        view.showToast(ResUtil.getString(R.string.cannot_send_answer))
    }
}
