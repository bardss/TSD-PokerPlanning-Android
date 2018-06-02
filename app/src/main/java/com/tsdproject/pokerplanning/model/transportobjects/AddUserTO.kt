package com.tsdproject.pokerplanning.model.transportobjects

import java.io.Serializable

data class AddUserTO (
        val FirstName: String,
        val LastName: String,
        val Email: String,
        val Password: String
): Serializable