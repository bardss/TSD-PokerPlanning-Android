package com.tsdproject.pokerplanning.results

import com.tsdproject.pokerplanning.base.BaseView

interface ResultsView : BaseView {
    fun updateAdapterValues(values: List<Int>)
}