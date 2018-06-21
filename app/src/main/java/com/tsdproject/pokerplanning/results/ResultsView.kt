package com.tsdproject.pokerplanning.results

import com.tsdproject.pokerplanning.base.BaseView
import com.tsdproject.pokerplanning.model.transportobjects.ResultTO

interface ResultsView : BaseView {
    fun updateAdapterValues(values: List<ResultTO>)
}