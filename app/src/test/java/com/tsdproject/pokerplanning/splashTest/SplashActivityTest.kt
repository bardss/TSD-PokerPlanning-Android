package com.tsdproject.pokerplanning.splashTest

import android.graphics.Typeface
import android.widget.TextView
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.splash.SplashActivity
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class SplashActivityTest {

    lateinit var splashActivity: SplashActivity

    @Before
    fun initData() {
        splashActivity = Robolectric.setupActivity(SplashActivity::class.java)
    }

    @Test
    fun shouldNotBeNull() {
        assertNotNull(splashActivity)
    }

    @Test
    fun shouldHaveRegularFont() {
        val appNameTextView = splashActivity.findViewById<TextView>(R.id.appNameTextView)
        val typeface = Typeface.createFromAsset(splashActivity.assets, "fonts/SourceCodePro-Regular.ttf")
        assertEquals(appNameTextView.typeface, typeface)
    }
}