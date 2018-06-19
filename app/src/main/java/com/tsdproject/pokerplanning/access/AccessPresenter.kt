package com.tsdproject.pokerplanning.access

import com.tsdproject.pokerplanning.base.BasePresenter

interface AccessPresenter : BasePresenter {
    fun login(login: String, password: String)
}
