package com.tsdproject.pokerplanning.cards

import android.content.Intent
import android.support.v7.widget.RecyclerView
import com.azoft.carousellayoutmanager.CarouselLayoutManager
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener

class CardsPresenterImpl(var view: CardsView): CardsPresenter {

    override fun initExtras(intent: Intent) {
    }

    override fun getCarouselLayoutManager(): RecyclerView.LayoutManager {
        val layoutManager = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, false)
        layoutManager.setPostLayoutListener(CarouselZoomPostLayoutListener())
        layoutManager.maxVisibleItems = 15
        layoutManager.addOnItemSelectionListener({ adapterPosition ->

        })
        return layoutManager
    }

}
