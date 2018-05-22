package com.tsdproject.pokerplanning.participants

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter
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
    }

    private fun setupTextFonts() {
        readyTextView.typeface = Typeface.createFromAsset(this.assets, "fonts/Roboto-Light.ttf")
    }

    private fun setupParticipantsList() {
        participantsAdapter = ParticipantsAdapter()
        participantsRecyclerView.layoutManager = LinearLayoutManager(this)
        participantsRecyclerView.adapter = participantsAdapter
    }


}
