package com.tsdproject.pokerplanning.createroom

import com.tsdproject.pokerplanning.base.BaseView


interface ManageRoomsView : BaseView {
    fun openRoomActivity(tableId: String?)
}