package io.nucleos.baseapp.ui.splash.mvp

import android.app.Activity
import android.widget.Toast
import io.nucleos.baseapp.app.modules.api.TestApi
import io.nucleos.baseapp.common.storage.SessionManager
import io.nucleos.baseapp.ui.splash.SplashActivity
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

class SplashModel(
        val activity: SplashActivity,
        val sessionManager: SessionManager,
        val testApi: TestApi) : SplashContract.Model {

    override val isLoggedIn
        get() = sessionManager.isLoggedIn

    override fun startHomeActivity() {
//        sessionManager.session = null
//        activity.finish()
//        HomeActivity.start(activity)
        Toast.makeText(activity, "startHomeActivity", Toast.LENGTH_LONG).show()
    }

    override fun startLoginActivity() {
//        sessionManager.clear()
//        activity.finish()
//        LoginActivity.start(activity)
        Toast.makeText(activity, "startLoginActivity", Toast.LENGTH_LONG).show()
    }

    override fun updateSession(): Completable {
        return testApi.test()
                .subscribeOn(Schedulers.io())
                .doOnSuccess {
                    Toast.makeText(activity, "updateSession 1", Toast.LENGTH_LONG).show()

                }
                .doOnError {
                    Toast.makeText(activity, "updateSession 2", Toast.LENGTH_LONG).show()
                    sessionManager.clear()
                }
                .toCompletable()
    }
}