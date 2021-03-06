package com.tsdproject.pokerplanning.base

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import io.paperdb.Paper
import timber.log.Timber

class ApplicationContext : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        MultiDex.install(this)
        Paper.init(this)
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        lateinit var appContext: Context
    }
}
