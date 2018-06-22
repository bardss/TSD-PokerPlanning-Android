package com.tsdproject.pokerplanning.cards

import android.support.v7.widget.RecyclerView
import com.tsdproject.pokerplanning.base.BasePresenter

interface CardsPresenter : BasePresenter {
    var canScrollHorizontally: Boolean
    fun getCarouselLayoutManager(): RecyclerView.LayoutManager
    fun sendAnswer(cardValue: String)
}
