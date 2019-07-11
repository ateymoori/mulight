package com.mulight.utils.bases

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.content.Context.MODE_PRIVATE
import android.content.ContextWrapper
import com.mulight.utils.entities.ImageSaveResultModel
import com.mulight.utils.enums.SavePhotoResult
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.*


class PublicMethods {
    companion object {

        fun saveToInternalStorage(
            context: Context,
            bitmapImage: Bitmap
        ): ImageSaveResultModel {
            val cw = ContextWrapper(context)
            val fileName = "${getUnixTime()}.jpg"
            val directory = cw.getDir("imageDir", MODE_PRIVATE)
            val imgPath = File(directory, fileName)
            var fos: FileOutputStream? = null
            try {
                fos = FileOutputStream(imgPath)
                bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos as OutputStream?)
                return ImageSaveResultModel(result = SavePhotoResult.SAVED, address = imgPath.absolutePath)
            } catch (e: Exception) {
                return ImageSaveResultModel(result = SavePhotoResult.ERROR, address = null)

            } finally {
                try {
                    fos?.close()
                } catch (e: IOException) {
                    return ImageSaveResultModel(result = SavePhotoResult.ERROR, address = null)
                }
            }
        }

        fun getSystemDateTime(): String {
            val sdf = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
            return sdf.format(Date())
        }

          fun getUnixTime(): Long = System.currentTimeMillis() / 1000L

    }
}