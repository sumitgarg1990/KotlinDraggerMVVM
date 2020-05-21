package com.example.sumit.doubtnutassignment.model

import android.os.Parcel
import android.os.Parcelable


data class NewsInfo(val title:String,val urlToImage:String,val description:String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(urlToImage)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewsInfo> {
        override fun createFromParcel(parcel: Parcel): NewsInfo {
            return NewsInfo(parcel)
        }

        override fun newArray(size: Int): Array<NewsInfo?> {
            return arrayOfNulls(size)
        }
    }
}
data class Articles(val articles:ArrayList<NewsInfo>) {
}

