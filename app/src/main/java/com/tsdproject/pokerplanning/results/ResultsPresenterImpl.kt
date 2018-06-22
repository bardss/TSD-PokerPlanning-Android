package com.tsdproject.pokerplanning.results

import android.content.Intent
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.model.transportobjects.ResultTO
import com.tsdproject.pokerplanning.model.utils.ResUtil
import com.tsdproject.pokerplanning.service.ServiceManager
import com.tsdproject.pokerplanning.service.receivers.GetResultsReceiver

class ResultsPresenterImpl(var view: ResultsView) : ResultsPresenter,
    GetResultsReceiver {

    override fun initExtras(intent: Intent) {
    }

    override fun getResults() {
        view.startProgressDialog(ResUtil.getString(R.string.progress_loading_text))
        ServiceManager.getResults(this)
    }

    override fun onGetResultsError() {
        view.stopProgressDialog()
    }

    override fun onGetResultsSuccess(results: List<ResultTO>) {
        view.updateAdapterValues(results)
        view.stopProgressDialog()
    }

    override fun convertValuesToInt(values: List<ResultTO>): List<Int> {
        val listOfIntValues = mutableListOf<Int>()
        values.forEach {
            it.value?.let {
                listOfIntValues.add(it.toInt())
            }
        }
        return listOfIntValues
    }
}