package com.tsdproject.pokerplanning.cardsTest

import com.tsdproject.pokerplanning.cards.CardsAdapter
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class CardsAdapterTest {

    lateinit var cardsAdapter: CardsAdapter

    @Before
    fun initData() {
        cardsAdapter = CardsAdapter()
    }

    @Test
    fun shouldNotBeNull() {
        assertNotNull(cardsAdapter)
    }

    @Test
    fun shouldAdapterListSizeEqualsItemCount() {
        val listOfCardValues = listOf(1, 2, 3, 5, 8, 13, 21, 34, 55)
        assertEquals(listOfCardValues.size, cardsAdapter.itemCount)
    }
}