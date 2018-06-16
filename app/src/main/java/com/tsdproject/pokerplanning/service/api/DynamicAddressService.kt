package com.tsdproject.pokerplanning.service.api

import retrofit2.http.GET
import rx.Observable

interface DynamicAddressService {

    @GET("tsd-ip.txt")
    fun getDynamicAddress(): Observable<String>

}