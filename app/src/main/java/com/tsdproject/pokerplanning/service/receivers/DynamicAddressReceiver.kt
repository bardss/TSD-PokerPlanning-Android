package com.tsdproject.pokerplanning.service.receivers

interface DynamicAddressReceiver {
    fun onGetDynamicAddressSuccess(dynamicAddress: String)

    fun onGetDynamicAddressError()
}