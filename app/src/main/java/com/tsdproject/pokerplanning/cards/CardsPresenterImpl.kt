package com.tsdproject.pokerplanning.cards

import android.content.Intent
import android.support.v7.widget.RecyclerView
import com.azoft.carousellayoutmanager.CarouselLayoutManager
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener

class CardsPresenterImpl(var view: CardsView) : CardsPresenter {

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
}
