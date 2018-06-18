package com.tsdproject.pokerplanning.createroom

import android.content.Intent
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.model.utils.ResUtil
import com.tsdproject.pokerplanning.service.ServiceManager
import com.tsdproject.pokerplanning.service.receivers.CreateTableReceiver

class ManageRoomsPresenterImpl(var view: ManageRoomsView): ManageRoomsPresenter, CreateTableReceiver {

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

}