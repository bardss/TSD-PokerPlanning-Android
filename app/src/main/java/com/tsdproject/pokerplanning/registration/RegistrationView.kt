package com.tsdproject.pokerplanning.registration

import com.tsdproject.pokerplanning.base.BaseView

interface RegistrationView : BaseView {
    fun showSuccessToast()
    fun navigateToAccess()
}