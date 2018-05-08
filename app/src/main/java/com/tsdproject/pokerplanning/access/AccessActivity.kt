package com.tsdproject.pokerplanning.access

import android.os.Bundle
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter

class AccessActivity : BaseActivity(), AccessView {

    private lateinit var presenter: AccessPresenter

    override fun providePresenter(): BasePresenter? {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access)
        presenter = AccessPresenterImpl(this)
    }

}
