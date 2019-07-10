package com.mulight.utils.entities

import com.mulight.utils.enums.SavePhotoResult

data class ImageSaveResultModel(
    val result: SavePhotoResult,
    val address: String?
)