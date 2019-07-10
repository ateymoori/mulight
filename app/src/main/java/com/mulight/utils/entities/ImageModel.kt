package com.mulight.utils.entities

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

data class ImageModel(
    val image: Bitmap,
    val name: String,
    val date: String
)