package com.tsdproject.pokerplanning.model.transportobjects

import java.io.Serializable

data class ParticipantsTO(
    val taskName: String,
    val participants: List<UserTO>
) : Serializable