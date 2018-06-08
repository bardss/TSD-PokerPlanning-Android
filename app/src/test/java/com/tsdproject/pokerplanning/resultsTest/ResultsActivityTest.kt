package com.tsdproject.pokerplanning.resultsTest

import android.support.v7.widget.GridLayoutManager
import com.tsdproject.pokerplanning.results.ResultsActivity
import com.tsdproject.pokerplanning.results.ResultsView
import junit.framework.Assert.*
import kotlinx.android.synthetic.main.activity_results.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ResultsActivityTest {

    lateinit var resultsActivity: ResultsActivity
    private var listOfCardValues = listOf(1,2,3,4,5)

    @Before
    fun initData() {
        resultsActivity = Robolectric.setupActivity(ResultsActivity::class.java)
    }

    @Test
    fun shouldNotBeNull() {
        assertNotNull(resultsActivity)
    }

    @Test
    fun shouldCardsAdapterBeEmpty() {
        val recyclerView = resultsActivity.resultsRecyclerView
        assertEquals(recyclerView.adapter.itemCount, 0)
    }

    @Test
    fun shouldAdapterHaveCorrectSize() {
        (resultsActivity as ResultsView).updateAdapterValues(listOfCardValues)
        val recyclerView = resultsActivity.resultsRecyclerView
        assertEquals(recyclerView.adapter.itemCount, listOfCardValues.size)
    }

    @Test
    fun shouldCountCorrectCardValuesAverage() {
        (resultsActivity as ResultsView).updateAdapterValues(listOfCardValues)
        val averageTextView = resultsActivity.averageTextView
        assertEquals(averageTextView.text.toString(), listOfCardValues.average().toFloat().toString())
    }

    @Test
    fun shouldUseGridLayoutManager() {
        val recyclerView = resultsActivity.resultsRecyclerView
        assertTrue(recyclerView.layoutManager is GridLayoutManager)
    }

}