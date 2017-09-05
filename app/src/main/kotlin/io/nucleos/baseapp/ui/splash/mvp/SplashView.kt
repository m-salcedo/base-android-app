package io.nucleos.baseapp.ui.splash.mvp

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import io.nucleos.baseapp.R
import io.nucleos.baseapp.common.RxActivity
import io.nucleos.baseapp.common.mvp.MVPView
import io.nucleos.baseapp.ui.splash.mvp.SplashContract

@SuppressLint("ViewConstructor")
class SplashView(override val activity: RxActivity): MVPView(activity), SplashContract.View {
    override fun inflateLayout(container: ViewGroup?): View? = inflate(activity, R.layout.activity_main, this)
}