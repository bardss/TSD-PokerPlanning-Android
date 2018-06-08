package com.tsdproject.pokerplanning.results

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter
import kotlinx.android.synthetic.main.activity_results.*

class ResultsActivity : BaseActivity(), ResultsView {

    lateinit var presenter: ResultsPresenter
    lateinit var adapter: ResultsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        presenter = ResultsPresenterImpl(this)
        setupRecyclerView()
        updateAdapterValues()
    }

    override fun providePresenter(): BasePresenter? {
        return presenter
    }

    fun setupRecyclerView() {
        resultsRecyclerView.layoutManager = GridLayoutManager(this, 3)
        adapter = ResultsListAdapter()
        resultsRecyclerView.adapter = adapter
    }

    private fun updateAdapterValues() {
        val temporaryList = listOf(1, 3, 5, 5, 8, 8)
        adapter.updateCardValues(temporaryList)
        averageTextView.text = temporaryList.average().toFloat().toString()
    }
}