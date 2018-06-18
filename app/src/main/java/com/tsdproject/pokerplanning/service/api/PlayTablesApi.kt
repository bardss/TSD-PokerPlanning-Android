package com.tsdproject.pokerplanning.service.api

import com.tsdproject.pokerplanning.model.transportobjects.TokenTO
import com.tsdproject.pokerplanning.model.transportobjects.UserTO
import com.tsdproject.pokerplanning.model.transportobjects.UserTableToken
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import rx.Observable

interface PlayTablesApi {

    @POST("playtables/create")
    fun createTable(@Body Token: TokenTO): Observable<String>

    @POST("playtables/join")
    fun joinTable(@Body userTableToken: UserTableToken) : Observable<Void>

    @GET("playtables/getParticipants")
    fun getParticipants(@Query("token") Token: String?) : Observable<List<UserTO>>
}