package com.tsdproject.pokerplanning.createroom

import android.content.Intent
import android.os.Bundle
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter
import com.tsdproject.pokerplanning.model.utils.EditTextUtil
import com.tsdproject.pokerplanning.participants.ParticipantsActivity
import kotlinx.android.synthetic.main.activity_create_room.*


class CreateRoomActivity : BaseActivity(), CreateRoomView {

    private lateinit var presenter: CreateRoomPresenter

    override fun providePresenter(): BasePresenter? {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_room)
        presenter = CreateRoomPresenterImpl(this)
        setupButtons()
    }

    private fun setupButtons() {
        createRoomButton.setOnClickListener({ onCreateButtonClick() })
        joinRoomButton.setOnClickListener({ onJoinButtonClick() })
    }

    private fun onJoinButtonClick() {
        EditTextUtil.checkIfEditTextEmpty(tableIdEditText)
        if (tableIdEditText.error.isNullOrEmpty()) {
            startActivity(Intent(this, ParticipantsActivity::class.java))
        }
    }

    private fun onCreateButtonClick() {
        EditTextUtil.checkIfEditTextEmpty(tableNameEditText)
        if (tableNameEditText.error.isNullOrEmpty()) {
            startActivity(Intent(this, ParticipantsActivity::class.java))
        }
    }
}