package com.tsdproject.pokerplanning.model.transportobjects

import java.io.Serializable

data class ResultTO(
    val value: String?,
    val user: UserResultsTO?
) : Serializable