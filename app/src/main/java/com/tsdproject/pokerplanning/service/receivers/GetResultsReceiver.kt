package com.tsdproject.pokerplanning.service.receivers

import com.tsdproject.pokerplanning.model.transportobjects.ResultTO

interface GetResultsReceiver {
    fun onGetResultsSuccess(results: List<ResultTO>)

    fun onGetResultsError()
}