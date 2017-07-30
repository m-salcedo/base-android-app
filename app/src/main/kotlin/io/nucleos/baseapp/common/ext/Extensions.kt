package io.nucleos.baseapp.common.ext

import android.content.SharedPreferences
import android.os.Parcel
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

inline fun <reified T: Parcelable> createParcel(
        crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
        object : Parcelable.Creator<T> {
            override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
            override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
        }

fun SharedPreferences.saveString(key: String, value: String) = edit().putString(key, value).apply()

fun ViewGroup.inflate(resourceId: Int, autoAttach: Boolean = false): View {
    return LayoutInflater.from(context).inflate(resourceId, this, autoAttach)
}

fun FragmentManager.add(containerId: Int, fragment: Fragment): Int {
    return beginTransaction()
            .add(containerId, fragment)
            .commit()
}

fun FragmentManager.replace(containerId: Int, fragment: Fragment, backStack: String? = ""): Int {
    val transaction = beginTransaction().replace(containerId, fragment)
    if (backStack != "") transaction.addToBackStack(backStack)
    return transaction.commit()
}

fun EditText.setError(resId: Int): Unit {
    error = context.resources.getString(resId)
}