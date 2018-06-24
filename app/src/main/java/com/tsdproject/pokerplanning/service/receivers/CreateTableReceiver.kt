package com.tsdproject.pokerplanning.service.receivers

interface CreateTableReceiver {
    fun onCreateTableSuccess(tableId: String)

    fun onCreateTableError()
}