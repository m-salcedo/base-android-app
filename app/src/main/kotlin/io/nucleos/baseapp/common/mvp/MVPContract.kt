package io.nucleos.baseapp.common.mvp

import android.view.ViewGroup
import io.nucleos.baseapp.common.RxActivity

abstract class MVPContract {

    interface Model

    interface View {
        val activity: RxActivity
        fun inflateLayout(container: ViewGroup? = null): android.view.View?
        fun showToast(message: String, longTime: Boolean = true)
        fun showToast(message: Int, longTime: Boolean = true)
        fun showProgress(message: String, cancelable: Boolean = false)
        fun showProgress(message: Int, cancelable: Boolean = false)
        fun hideProgress()
    }

    interface Presenter {
        val view: View
        val model: Model
        fun onCreate()
        fun onDestroy()
    }
}