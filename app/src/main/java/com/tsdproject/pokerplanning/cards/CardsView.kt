package com.tsdproject.pokerplanning.cards

import com.tsdproject.pokerplanning.base.BaseView

interface CardsView : BaseView {
    fun setCarousleScrollable(isScrollable: Boolean)
    fun onChooseCardClick(cardValue: Int)
}
