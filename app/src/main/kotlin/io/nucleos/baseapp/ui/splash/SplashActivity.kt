package io.nucleos.baseapp.ui.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.nucleos.baseapp.R

/**
 * Created by Mariangela Salcedo (mariangela@nucleos.io) on 7/28/17.
 * Copyright (c) 2017 Nucelos IO. All rights reserved.
 */
class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}