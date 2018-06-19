package com.tsdproject.pokerplanning.model.transportobjects

import java.io.Serializable

data class UserLoginTO(
    val Email: String,
    val Password: String
) : Serializable