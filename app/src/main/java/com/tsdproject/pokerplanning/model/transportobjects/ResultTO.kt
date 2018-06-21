package com.tsdproject.pokerplanning.model.transportobjects

import java.io.Serializable

data class ResultTO(
    val Value: String,
    val User: UserResultsTO
) : Serializable