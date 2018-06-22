package com.tsdproject.pokerplanning.cards

import com.tsdproject.pokerplanning.base.BaseView

interface CardsView : BaseView {
    fun setCarouselScrollable(isScrollable: Boolean)
    fun onChooseCardClick(cardValue: String)
    fun navigateToResults()
    fun isReady(): Boolean
}
