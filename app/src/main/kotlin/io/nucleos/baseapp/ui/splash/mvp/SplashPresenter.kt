package io.nucleos.baseapp.ui.splash.mvp

import io.nucleos.baseapp.ui.splash.mvp.SplashContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class SplashPresenter(
        override val view: SplashContract.View,
        override val model: SplashContract.Model): SplashContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        if (model.isLoggedIn) {
            compositeDisposable.add(observeUpdateSession())
        } else {
            model.startLoginActivity()
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

    private fun observeUpdateSession(): Disposable = model.updateSession()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                    { model.startHomeActivity() },
                    {
                        it.printStackTrace()
                        model.startLoginActivity()
                    })

}