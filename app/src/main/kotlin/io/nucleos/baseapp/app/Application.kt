package io.nucleos.baseapp.app

import android.support.multidex.MultiDexApplication

class Application : MultiDexApplication() {

    private val TAG = "TAG_${Application::class.java.simpleName}"

    override fun onCreate() {
        super.onCreate()
    }
}