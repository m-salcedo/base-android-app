package io.nucleos.baseapp.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import io.nucleos.baseapp.common.RxActivity
import org.jetbrains.anko.intentFor

class SplashActivity: RxActivity() {

    companion object {
        fun start(context: Context) {
            val intent = context.intentFor<SplashActivity>()
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

//    @Inject lateinit var presenter: SplashContract.Presenter
//    @Inject lateinit var view: SplashContract.View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        initializeComponent()
//        setContentView(view.inflateLayout())
//        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
//        presenter.onDestroy()
    }

    private fun initializeComponent() {
//        DaggerSplashComponent.builder()
//                .splashModule(SplashModule(this))
//                .appComponent(MystApp.component)
//                .build()
//                .inject(this)
    }
}