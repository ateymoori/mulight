package com.mulight.utils.entities

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class ImageDBModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val title: String,
    val date: String,
    var address: String? = ""
)