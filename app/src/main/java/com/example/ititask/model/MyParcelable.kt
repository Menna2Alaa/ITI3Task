package com.example.ititask.model

import android.os.Parcel
import android.os.Parcelable

class MyParcelable(private val mData: Int) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        out.writeInt(mData)
    }

    companion object CREATOR : Parcelable.Creator<MyParcelable> {
        override fun createFromParcel(parcel: Parcel): MyParcelable {
            return MyParcelable(parcel)
        }

        override fun newArray(size: Int): Array<MyParcelable?> {
            return arrayOfNulls(size)
        }
    }
}