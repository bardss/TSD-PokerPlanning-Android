package com.tsdproject.pokerplanning.participants

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter
import com.tsdproject.pokerplanning.cards.CardsActivity
import com.tsdproject.pokerplanning.model.transportobjects.UserTO
import kotlinx.android.synthetic.main.activity_participants.*

class ParticipantsActivity : BaseActivity(), ParticipantsView {

    private lateinit var presenter: ParticipantsPresenter
    private lateinit var participantsAdapter: ParticipantsAdapter

    override fun providePresenter(): BasePresenter? {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_participants)
        presenter = ParticipantsPresenterImpl(this)
    }

    override fun onStart() {
        super.onStart()
        setupTextFonts()
        setupParticipantsList()
        setReadySwitchListener()
        presenter.setupTableIdView()
        presenter.getParticipants()
        presenter.setupStartGameButton()
    }

    override fun onPause() {
        super.onPause()
        presenter.stopGetParticipants()
    }

    override fun setupTableIdView(tableId: String?) {
        if (tableId == null) {
            roomIdLayout.visibility = View.GONE
        } else {
            roomIdTextView.text = tableId
        }
    }

    private fun setReadySwitchListener() {
        readySwitch.setCheckedImmediately(presenter.isRoomCreator)
        readySwitch.setOnCheckedChangeListener { _, checked ->
            presenter.setUserReadyStatus(checked)
        }
    }

    private fun setupTextFonts() {
        readyTextView.typeface = Typeface.createFromAsset(this.assets, "fonts/Roboto-Light.ttf")
        roomIdLabelTextView.typeface = Typeface.createFromAsset(this.assets, "fonts/Roboto-Light.ttf")
        roomIdTextView.typeface = Typeface.createFromAsset(this.assets, "fonts/Roboto-Medium.ttf")
    }

    private fun setupParticipantsList() {
        participantsAdapter = ParticipantsAdapter()
        participantsRecyclerView.layoutManager = LinearLayoutManager(this)
        participantsRecyclerView.adapter = participantsAdapter
    }

    override fun updateParticipantsList(users: List<UserTO>) {
        participantsAdapter.setUsersList(users)
    }

    override fun showButtonForTableOwner() {
        startGameButton.visibility = View.VISIBLE
        readySwitch.visibility = View.GONE
        readyTextView.visibility = View.GONE
        startGameButton.setOnClickListener { presenter.startGame() }
    }

    override fun navigateToCardsActivity() {
        startActivity(Intent(this, CardsActivity::class.java))
    }

    override fun switchBackReadyStatus() {
        readySwitch.setCheckedImmediately(!readySwitch.isChecked)
    }

    override fun isReady(): Boolean {
        return readySwitch.isChecked
    }

    override fun kickParticipant(email: String) {
        presenter.kickParticipant(email)
    }

}
