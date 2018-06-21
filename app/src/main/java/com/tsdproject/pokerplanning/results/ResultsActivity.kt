package com.tsdproject.pokerplanning.results

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter
import com.tsdproject.pokerplanning.model.transportobjects.ResultTO
import kotlinx.android.synthetic.main.activity_results.*

class ResultsActivity : BaseActivity(), ResultsView {

    lateinit var presenter: ResultsPresenter
    lateinit var adapter: ResultsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        presenter = ResultsPresenterImpl(this)
        setupRecyclerView()
        presenter.getResults()
    }

    override fun providePresenter(): BasePresenter? {
        return presenter
    }

    private fun setupRecyclerView() {
        resultsRecyclerView.layoutManager = GridLayoutManager(this, 3)
        adapter = ResultsListAdapter()
        resultsRecyclerView.adapter = adapter
    }

    override fun updateAdapterValues(values: List<ResultTO>) {
        adapter.updateCardValues(values)
//        averageTextView.text = values.average().toFloat().toString()
    }
}