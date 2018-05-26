package com.tsdproject.pokerplanning.cardsTest

import com.azoft.carousellayoutmanager.CarouselLayoutManager
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.access.AccessActivity
import com.tsdproject.pokerplanning.cards.CardsActivity
import com.tsdproject.pokerplanning.cards.CardsAdapter
import junit.framework.Assert
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import kotlinx.android.synthetic.main.activity_access.*
import kotlinx.android.synthetic.main.activity_cards.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CardsActivityTest {

    lateinit var cardsActivity: CardsActivity

    @Before
    fun initData() {
        cardsActivity = Robolectric.setupActivity(CardsActivity::class.java)
    }

    @Test
    fun shouldNotBeNull() {
        assertNotNull(cardsActivity)
    }

    @Test
    fun shouldCardsAdapterNotBeNull() {
        val adapter = cardsActivity.cardsRecyclerView.adapter
        assertNotNull(adapter)
    }

    @Test
    fun shouldCardsAdapterBeOfRightType() {
        val adapter = cardsActivity.cardsRecyclerView.adapter
        assertTrue(adapter is CardsAdapter)
    }

    @Test
    fun shouldLayoutManagerBeOfRightType() {
        val recyclerView = cardsActivity.cardsRecyclerView
        assertTrue(recyclerView.layoutManager is CarouselLayoutManager)
    }
}