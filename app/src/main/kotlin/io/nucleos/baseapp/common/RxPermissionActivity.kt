package io.nucleos.baseapp.common

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import com.tbruyelle.rxpermissions2.RxPermissions
import io.nucleos.baseapp.R
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

abstract class RxPermissionActivity: RxActivity() {

    abstract val permissions: Array<String>

    private val TAG = "TAG_${RxPermissionActivity::class.java.simpleName}"
    private val acceptedPermissionsSubject = PublishSubject.create<Any>()
    private val rxPermissions by lazy { RxPermissions(this) }

    var requestDisposable: Disposable? = null
    val acceptedPermissionsObservable: Observable<Any> = acceptedPermissionsSubject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        request()
    }

    private fun request() {
        Log.d(TAG, "request permissions")
        requestDisposable?.dispose()
        requestDisposable = rxPermissions.request(*permissions)
                .subscribe{
                    if (it) {
                        Log.d(TAG, "permissions accepted")
                        acceptedPermissionsSubject.onNext(Any())
                    } else {
                        Log.d(TAG, "permissions rejected")
                        showRejectedPermissionsDialog()
                    }
                }
    }

    private fun showRejectedPermissionsDialog() {
        val title = resources.getString(R.string.permissions_denied_title)
        val message = resources.getString(R.string.alert_permissions_denied)
        val buttonText = resources.getString(android.R.string.ok)
        val builder = AlertDialog.Builder(this)
        builder.apply {
            setCancelable(false)
            setTitle(title)
            setMessage(message)
            setNeutralButton(buttonText, { dialog, _ ->
                request()
                dialog.dismiss()
            })
        }
        builder.show()
    }
}