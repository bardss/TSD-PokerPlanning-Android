package com.tsdproject.pokerplanning.manageroom

import com.tsdproject.pokerplanning.base.BasePresenter

interface ManageRoomsPresenter : BasePresenter {
    fun createRoom()
    fun joinTable(roomId: String)
}