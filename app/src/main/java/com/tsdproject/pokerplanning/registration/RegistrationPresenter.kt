package com.tsdproject.pokerplanning.registration

import com.tsdproject.pokerplanning.base.BasePresenter
import com.tsdproject.pokerplanning.model.transportobjects.AddUserTO


interface RegistrationPresenter : BasePresenter {
    fun registerUser(addUser: AddUserTO)
}