package io.nucleos.baseapp.common

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

open class RxActivity : AppCompatActivity() {

    private var onActivityResultSubject: PublishSubject<Result>? = null
    val onActivityResultObservable: Observable<Result> by lazy {
        onActivityResultSubject = PublishSubject.create()
        onActivityResultSubject as Observable<Result>
    }

    private var onCreateSubject: PublishSubject<Any>? = null
    val onCreateObservable: Observable<Any> by lazy {
        onCreateSubject = PublishSubject.create()
        onCreateSubject as Observable<Any>
    }

    private var onRestartSubject: PublishSubject<Any>? = null
    val onRestartObservable: Observable<Any> by lazy {
        onRestartSubject = PublishSubject.create()
        onRestartSubject as Observable<Any>
    }

    private var onStartSubject: PublishSubject<Any>? = null
    val onStartObservable: Observable<Any> by lazy {
        onStartSubject = PublishSubject.create()
        onStartSubject as Observable<Any>
    }

    private var onResumeSubject: PublishSubject<Any>? = null
    val onResumeObservable: Observable<Any> by lazy {
        onResumeSubject = PublishSubject.create()
        onResumeSubject as Observable<Any>
    }

    private var onPauseSubject: PublishSubject<Any>? = null
    val onPauseObservable: Observable<Any> by lazy {
        onPauseSubject = PublishSubject.create()
        onPauseSubject as Observable<Any>
    }

    private var onStopSubject: PublishSubject<Any>? = null
    val onStopObservable: Observable<Any> by lazy {
        onStopSubject = PublishSubject.create()
        onStopSubject as Observable<Any>
    }

    private var onDestroySubject: PublishSubject<Any>? = null
    val onDestroyObservable: Observable<Any> by lazy {
        onDestroySubject = PublishSubject.create()
        onDestroySubject as Observable<Any>
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        onActivityResultSubject?.onNext(Result(requestCode, resultCode, data))
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateSubject?.onNext(savedInstanceState)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun onRestart() {
        super.onRestart()
        onRestartSubject?.onNext(Any())
    }

    override fun onStart() {
        super.onStart()
        onStartSubject?.onNext(Any())
    }

    override fun onResume() {
        super.onResume()
        onResumeSubject?.onNext(Any())
    }

    override fun onPause() {
        super.onPause()
        onPauseSubject?.onNext(Any())

    }

    override fun onStop() {
        super.onStop()
        onStopSubject?.onNext(Any())
    }

    override fun onDestroy() {
        super.onDestroy()
        onDestroySubject?.onNext(Any())
    }

    /**
     * @description Represent the result of 'onActivityResult' params
     */
    data class Result(val requestCode: Int, val resultCode: Int, val data: Intent?)
}
