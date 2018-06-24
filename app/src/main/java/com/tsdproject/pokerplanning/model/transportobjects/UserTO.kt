package com.tsdproject.pokerplanning.model.transportobjects

import java.io.Serializable

data class UserTO(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val isReady: Boolean
) : Serializable