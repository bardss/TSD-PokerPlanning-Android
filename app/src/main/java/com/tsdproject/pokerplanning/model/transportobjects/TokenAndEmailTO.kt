package com.tsdproject.pokerplanning.model.transportobjects

import java.io.Serializable

data class TokenAndEmailTO(
    val UserToken: String?,
    val ParticipantEmail: String
) : Serializable