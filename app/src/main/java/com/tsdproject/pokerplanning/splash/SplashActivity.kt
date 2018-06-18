package com.tsdproject.pokerplanning.splash

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Toast
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.access.AccessActivity
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter
import com.tsdproject.pokerplanning.model.utils.ResUtil
import com.tsdproject.pokerplanning.model.utils.ToastUtil
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
        presenter.getDynamicAddress()
    }

    override fun setupNextViewDelay() {
        presenter.handleSplashScreen({
            startActivity(Intent(this, AccessActivity::class.java))
        })
    }

    private fun setupLogoFont() {
        appNameTextView.typeface = Typeface.createFromAsset(this.assets, "fonts/SourceCodePro-Regular.ttf")
    }

    override fun showAddressErrorToast() {
        ToastUtil.show(this, ResUtil.getString(R.string.cannot_download_server_address), Toast.LENGTH_LONG)
    }
}
