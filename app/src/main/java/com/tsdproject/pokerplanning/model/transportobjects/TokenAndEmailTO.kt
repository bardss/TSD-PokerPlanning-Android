package com.tsdproject.pokerplanning.model.transportobjects

import java.io.Serializable

data class TokenAndEmailTO(
    val Email: String,
    val Password: String
) : Serializable