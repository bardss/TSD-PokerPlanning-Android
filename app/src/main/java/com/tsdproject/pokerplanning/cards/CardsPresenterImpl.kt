package com.tsdproject.pokerplanning.cards

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.azoft.carousellayoutmanager.CarouselLayoutManager
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.tsdproject.pokerplanning.database.LocalDatabase
import com.tsdproject.pokerplanning.model.transportobjects.AnswerTokenTO
import com.tsdproject.pokerplanning.service.ServiceManager
import com.tsdproject.pokerplanning.service.ServiceProvider
import com.tsdproject.pokerplanning.service.receivers.SendAnswerReceiver

class CardsPresenterImpl(var view: CardsView) : CardsPresenter, SendAnswerReceiver {

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

    override fun sendAnswer(cardValue: Int){
        ServiceManager.sendAnswer(this, AnswerTokenTO(cardValue, LocalDatabase.getUserToken()))
    }

    override fun onSendAnswerSuccess() {
    }

    override fun onSendAnswerError() {
    }
}
