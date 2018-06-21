package com.tsdproject.pokerplanning.model.transportobjects

import java.io.Serializable

data class UserResultsTO(
    val email: String,
    val firstName: String,
    val lastName: String
) : Serializable