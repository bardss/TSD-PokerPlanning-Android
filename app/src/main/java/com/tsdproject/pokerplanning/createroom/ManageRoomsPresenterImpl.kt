package com.tsdproject.pokerplanning.createroom

import android.content.Intent
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.database.LocalDatabase
import com.tsdproject.pokerplanning.model.transportobjects.UserTableTokenTO
import com.tsdproject.pokerplanning.model.utils.ResUtil
import com.tsdproject.pokerplanning.service.ServiceManager
import com.tsdproject.pokerplanning.service.receivers.CreateTableReceiver
import com.tsdproject.pokerplanning.service.receivers.JoinTableReceiver

class ManageRoomsPresenterImpl(var view: ManageRoomsView) : ManageRoomsPresenter, CreateTableReceiver,
    JoinTableReceiver {

    lateinit var joinTableId: String

    override fun initExtras(intent: Intent) {
    }

    override fun createRoom() {
        view.startProgressDialog(ResUtil.getString(R.string.progress_loading_text))
        ServiceManager.createTable(this)
    }

    override fun onCreateTableError() {
        view.stopProgressDialog()
    }

    override fun onCreateTableSuccess(tableId: String) {
        view.stopProgressDialog()
        view.openRoomActivity(tableId)
    }

    override fun joinTable(roomId: String) {
        view.startProgressDialog(ResUtil.getString(R.string.progress_loading_text))
        joinTableId = roomId
        val userTableToken = UserTableTokenTO(LocalDatabase.getUserToken(), roomId)
        ServiceManager.joinTable(this, userTableToken)
    }

    override fun onJoinTableError() {
        view.stopProgressDialog()
    }

    override fun onJoinTableSuccess() {
        view.stopProgressDialog()
        view.openRoomActivity(joinTableId)
    }
}