package io.nucleos.baseapp.ui.splash.di

import dagger.Module
import dagger.Provides
import io.nucleos.baseapp.app.modules.api.TestApi
import io.nucleos.baseapp.common.storage.SessionManager
import io.nucleos.baseapp.ui.splash.SplashActivity
import io.nucleos.baseapp.ui.splash.mvp.SplashContract
import io.nucleos.baseapp.ui.splash.mvp.SplashModel
import io.nucleos.baseapp.ui.splash.mvp.SplashPresenter
import io.nucleos.baseapp.ui.splash.mvp.SplashView

@Module
class SplashModule(private val activity: SplashActivity) {

    @Provides
    @SplashScope
    fun provideSplashActivity(): SplashActivity = activity

    @Provides
    @SplashScope
    fun provideView(): SplashContract.View = SplashView(activity)

    @Provides
    @SplashScope
    fun providePresenter(
            view: SplashContract.View,
            model: SplashContract.Model): SplashContract.Presenter =
            SplashPresenter(view = view, model = model)

    @Provides
    @SplashScope
    fun provideModel(
            activity: SplashActivity,
            sessionManager: SessionManager,
            testApi: TestApi): SplashContract.Model =
            SplashModel(activity = activity, sessionManager = sessionManager, testApi = testApi)
}