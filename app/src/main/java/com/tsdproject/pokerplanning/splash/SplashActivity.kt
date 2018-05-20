package com.tsdproject.pokerplanning.splash

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.access.AccessActivity
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity(), SplashView {

    private lateinit var presenter: SplashPresenter

    override fun providePresenter(): BasePresenter? {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter = SplashPresenterImpl(this)
    }

    override fun onStart() {
        super.onStart()
        setupLogoFont()
        setupNextViewDelay()
    }

    private fun setupNextViewDelay() {
        presenter.handleSplashScreen({
            startActivity(Intent(this, AccessActivity::class.java))
        })
    }

    private fun setupLogoFont() {
        appNameTextView.typeface = Typeface.createFromAsset(this.assets, "fonts/SourceCodePro-Regular.ttf")
    }
}
