package com.tsdproject.pokerplanning.service.api

import com.tsdproject.pokerplanning.model.transportobjects.TokenTO
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface GamesApi {

    @POST("games/start")
    fun startGame(@Body Token: TokenTO): Observable<Void>
}