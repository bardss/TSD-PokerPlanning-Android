package com.tsdproject.pokerplanning.access

import com.tsdproject.pokerplanning.base.BaseView

interface AccessView : BaseView {

    fun navigateToCreateRoom()

    fun setInputErrors()

    fun clearEditTexts()

    fun getUserLogin(): String

    fun setSavedEmail(email: String)
}
