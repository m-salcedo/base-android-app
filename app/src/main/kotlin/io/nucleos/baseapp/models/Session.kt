package io.nucleos.baseapp.models

import android.os.Parcel
import android.os.Parcelable
import io.nucleos.baseapp.common.ext.createParcel

/**
 * Created by Mariangela Salcedo (mariangela@nucleos.io) on 7/29/17.
 * Copyright (c) 2017 Nucelos IO. All rights reserved.
 */
data class Session(
        val id: String? = null,
        val createdAt: String? = null
): Parcelable {

    companion object {
        @JvmField
        val CREATOR = createParcel {
            val id = it.readString()
            val createdAt = it.readString()

            Session(
                    id = id,
                    createdAt = createdAt)
        }
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(id)
        dest?.writeString(createdAt)
    }
}