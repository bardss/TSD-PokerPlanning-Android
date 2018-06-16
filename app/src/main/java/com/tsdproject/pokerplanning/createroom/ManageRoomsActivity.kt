package com.tsdproject.pokerplanning.createroom

import android.content.Intent
import android.os.Bundle
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter
import com.tsdproject.pokerplanning.model.IntentKeys
import com.tsdproject.pokerplanning.model.utils.EditTextUtil
import com.tsdproject.pokerplanning.participants.ParticipantsActivity
import kotlinx.android.synthetic.main.activity_create_join_room.*

class ManageRoomsActivity : BaseActivity(), ManageRoomsView {

    private lateinit var presenter: ManageRoomsPresenter

    override fun providePresenter(): BasePresenter? {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_join_room)
        presenter = ManageRoomsPresenterImpl(this)
        setupButtons()
    }

    private fun setupButtons() {
        createRoomButton.setOnClickListener({ presenter.createRoom() })
        joinRoomButton.setOnClickListener({ onJoinButtonClick() })
    }

    private fun onJoinButtonClick() {
        EditTextUtil.checkIfEditTextEmpty(tableIdEditText)
        if (tableIdEditText.error.isNullOrEmpty()) {
            startActivity(Intent(this, ParticipantsActivity::class.java))
        }
    }

    override fun openRoomActivity(tableId: String) {
        startActivity(Intent(this, ParticipantsActivity::class.java)
            .putExtra(IntentKeys.TABLE_ID, tableId))
    }
}