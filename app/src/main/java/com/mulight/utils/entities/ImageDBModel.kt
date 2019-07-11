package com.mulight.utils.entities

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "images")
data class ImageDBModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val title: String,
    val date: String,
    var address: String? = ""
): Parcelable