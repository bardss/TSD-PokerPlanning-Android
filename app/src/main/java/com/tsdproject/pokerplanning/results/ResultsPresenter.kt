package com.tsdproject.pokerplanning.results

import com.tsdproject.pokerplanning.base.BasePresenter
import com.tsdproject.pokerplanning.model.transportobjects.ResultTO

interface ResultsPresenter : BasePresenter {
    fun getResults()
    fun convertValuesToInt(values: List<ResultTO>): List<Int>
}