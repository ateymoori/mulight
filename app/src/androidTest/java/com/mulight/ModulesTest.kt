package com.mulight

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Handler
import android.os.Looper
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.mulight.repo.DBHelper
import com.mulight.utils.bases.MyApplication
import com.mulight.utils.bases.PublicMethods
import com.mulight.utils.entities.ImageDBModel
import com.mulight.utils.entities.ImageSaveResultModel
import com.mulight.utils.enums.SavePhotoResult
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before
import java.io.File
import androidx.test.InstrumentationRegistry.getTargetContext
import androidx.test.core.app.ApplicationProvider.getApplicationContext


@RunWith(AndroidJUnit4::class)
class ModulesTest {

    lateinit var mContext: Context
    @Before
    fun setup() {
        mContext = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
    }


    @Test
    fun bitmapStoreModule() {

        val w = 200
        val h = 200
        val conf = Bitmap.Config.ARGB_8888
        val bmp = Bitmap.createBitmap(w, h, conf)
        val result = PublicMethods.saveToInternalStorage(mContext, bmp)
        val fileAddress = result.address

        val file = File(fileAddress)
        if (!file.exists()) {
            fail("File not found, bitmap not saved")
        }
    }


}
