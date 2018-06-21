package com.tsdproject.pokerplanning.resultsTest

import android.support.v7.widget.GridLayoutManager
import com.nhaarman.mockito_kotlin.anyOrNull
import com.nhaarman.mockito_kotlin.whenever
import com.tsdproject.pokerplanning.model.transportobjects.ResultTO
import com.tsdproject.pokerplanning.model.transportobjects.UserResultsTO
import com.tsdproject.pokerplanning.results.ResultsActivity
import com.tsdproject.pokerplanning.results.ResultsView
import com.tsdproject.pokerplanning.service.ServiceProvider
import com.tsdproject.pokerplanning.service.api.GamesApi
import junit.framework.Assert.*
import kotlinx.android.synthetic.main.activity_results.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import rx.Observable

@RunWith(RobolectricTestRunner::class)
class ResultsActivityTest {

    @Mock
    private var gamesApi = Mockito.mock(GamesApi::class.java)

    lateinit var resultsActivity: ResultsActivity
    private var listOfCardValues = listOf(
        ResultTO("1", UserResultsTO("email1@email.pl", "Jan1", "Nowak")),
        ResultTO("2", UserResultsTO("email2@email.pl", "Jan2", "Nowak")),
        ResultTO("3", UserResultsTO("email3@email.pl", "Jan3", "Nowak")
        )
    )

    @Before
    fun initData() {
        whenever(gamesApi.getResults(anyOrNull())).thenReturn(
            Observable.just(listOfCardValues)
        )

        ServiceProvider.gamesService = gamesApi

        resultsActivity = Robolectric.setupActivity(ResultsActivity::class.java)
    }

    @Test
    fun shouldNotBeNull() {
        assertNotNull(resultsActivity)
    }

    @Test
    fun shouldCardsAdapterBeEmpty() {
        val recyclerView = resultsActivity.resultsRecyclerView
        assertEquals(recyclerView.adapter.itemCount, listOfCardValues.size)
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
        val listOfInts = convertValuesToInt(listOfCardValues)
        assertEquals(averageTextView.text.toString(), listOfInts.average().toFloat().toString())
    }

    @Test
    fun shouldUseGridLayoutManager() {
        val recyclerView = resultsActivity.resultsRecyclerView
        assertTrue(recyclerView.layoutManager is GridLayoutManager)
    }

    private fun convertValuesToInt(values: List<ResultTO>): List<Int> {
        val listOfIntValues = mutableListOf<Int>()
        values.forEach {
            it.value?.let {
                listOfIntValues.add(it.toInt())
            }
        }
        return listOfIntValues
    }
}