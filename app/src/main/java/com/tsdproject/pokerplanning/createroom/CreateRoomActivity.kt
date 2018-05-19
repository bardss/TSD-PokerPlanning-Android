package com.tsdproject.pokerplanning.createroom

import android.os.Bundle
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.access.AccessPresenter
import com.tsdproject.pokerplanning.access.AccessPresenterImpl
import com.tsdproject.pokerplanning.access.AccessView
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter
import kotlinx.android.synthetic.main.activity_access.*


class CreateRoomActivity : BaseActivity(), CreateRoomView {

    private lateinit var presenter: CreateRoomPresenter

    override fun providePresenter(): BasePresenter? {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_room)
        presenter = CreateRoomPresenterImpl(this)
    }
}