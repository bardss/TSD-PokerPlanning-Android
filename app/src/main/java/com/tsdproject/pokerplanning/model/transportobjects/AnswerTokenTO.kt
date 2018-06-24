package com.tsdproject.pokerplanning.model.transportobjects

import java.io.Serializable

data class AnswerTokenTO(
    val Answer: String,
    val Token: String?
) : Serializable