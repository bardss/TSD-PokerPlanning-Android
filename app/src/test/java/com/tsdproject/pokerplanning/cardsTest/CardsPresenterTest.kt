//package com.tsdproject.pokerplanning.cardsTest
//
//import com.azoft.carousellayoutmanager.CarouselLayoutManager
//import com.tsdproject.pokerplanning.cards.CardsActivity
//import com.tsdproject.pokerplanning.cards.CardsAdapter
//import com.tsdproject.pokerplanning.cards.CardsPresenter
//import com.tsdproject.pokerplanning.cards.CardsPresenterImpl
//import junit.framework.Assert
//import junit.framework.Assert.assertNotNull
//import kotlinx.android.synthetic.main.activity_cards.*
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.robolectric.Robolectric
//import org.robolectric.RobolectricTestRunner
//
//@RunWith(RobolectricTestRunner::class)
//class CardsPresenterTest {
//
//    lateinit var cardsActivity: CardsActivity
//    lateinit var cardsPresenter: CardsPresenterImpl
//
//    @Before
//    fun initData() {
//        cardsActivity = Robolectric.setupActivity(CardsActivity::class.java)
//        cardsPresenter = CardsPresenterImpl(cardsActivity)
//    }
//
//    @Test
//    fun shouldNotBeNull() {
//        assertNotNull(cardsPresenter)
//    }
//
//    @Test
//    fun shouldLayoutManagerBeOfRightType() {
//        Assert.assertTrue(cardsPresenter.getCarouselLayoutManager() is CarouselLayoutManager)
//    }
//}