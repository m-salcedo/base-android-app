package io.nucleos.baseapp.ui.splash.mvp

import io.nucleos.baseapp.common.mvp.MVPContract
import io.reactivex.Completable

class SplashContract {

    interface View: MVPContract.View

    interface Presenter: MVPContract.Presenter

    interface Model: MVPContract.Model {
        val isLoggedIn: Boolean
        fun updateSession(): Completable
        fun startHomeActivity()
        fun startLoginActivity()
    }
}