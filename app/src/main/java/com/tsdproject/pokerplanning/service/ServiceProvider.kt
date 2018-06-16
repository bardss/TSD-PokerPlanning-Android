package com.tsdproject.pokerplanning.service

import com.tsdproject.pokerplanning.service.api.DynamicAddressService
import com.tsdproject.pokerplanning.service.api.PlayTablesApi
import com.tsdproject.pokerplanning.service.api.UsersApi

object ServiceProvider {

    var SERVICE_ENDPOINT: String = ""
    private const val DYNAMIC_ADDRESS_ENDPOINT = "https://sandbox27.neocities.org/"

    var dynamicAddressService: DynamicAddressService =
        ServiceFactory.createRetrofitService(DynamicAddressService::class.java, DYNAMIC_ADDRESS_ENDPOINT)

    val usersService: UsersApi by lazy {
        ServiceFactory.createRetrofitService(UsersApi::class.java, SERVICE_ENDPOINT)
    }

    val playTablesService: PlayTablesApi by lazy {
        ServiceFactory.createRetrofitService(PlayTablesApi::class.java, SERVICE_ENDPOINT)
    }
}