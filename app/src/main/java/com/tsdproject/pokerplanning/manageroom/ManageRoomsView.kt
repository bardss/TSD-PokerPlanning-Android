package com.tsdproject.pokerplanning.manageroom

import com.tsdproject.pokerplanning.base.BaseView

interface ManageRoomsView : BaseView {
    fun openRoomActivity(tableId: String?, isRoomCreator: Boolean)
}