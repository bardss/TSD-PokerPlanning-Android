package com.tsdproject.pokerplanning.base

import android.content.Intent

interface BasePresenter {
    fun initExtras(intent: Intent)
}