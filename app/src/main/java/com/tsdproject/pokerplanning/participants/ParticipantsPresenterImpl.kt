package com.tsdproject.pokerplanning.participants

import android.content.Intent
import com.tsdproject.pokerplanning.model.IntentKeys

class ParticipantsPresenterImpl(var view: ParticipantsView): ParticipantsPresenter {

    private var tableId: String? = null

    override fun initExtras(intent: Intent) {
        tableId = intent.getSerializableExtra(IntentKeys.TABLE_ID) as? String
    }

    override fun setupTableIdView() {
        view.setupTableIdView(tableId)
    }

}
