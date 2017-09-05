package io.nucleos.baseapp.ui.splash.di

import dagger.Component
import io.nucleos.baseapp.app.di.AppComponent
import io.nucleos.baseapp.ui.splash.SplashActivity

@SplashScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(SplashModule::class))
interface SplashComponent {
    fun inject(activity: SplashActivity): Unit
}