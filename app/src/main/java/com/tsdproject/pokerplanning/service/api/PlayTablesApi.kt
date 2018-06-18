package com.tsdproject.pokerplanning.service.api

import com.tsdproject.pokerplanning.model.transportobjects.TokenTO
import com.tsdproject.pokerplanning.model.transportobjects.UserTableToken
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface PlayTablesApi {

    @POST("playtables/create")
    fun createTable(@Body Token: TokenTO): Observable<String>

    @POST("playtables/join")
    fun joinTable(@Body userTableToken: UserTableToken) : Observable<Void>
}