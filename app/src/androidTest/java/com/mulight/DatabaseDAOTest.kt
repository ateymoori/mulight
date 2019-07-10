package com.mulight

import android.os.Handler
import android.os.Looper
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mulight.repo.DBHelper
import com.mulight.utils.entities.ImageDBModel
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class DatabaseDAOTest {

    private var db: DBHelper? = null
    @Before
    fun initDb() {
        db = DBHelper.getInstance()
    }

    @Test
    fun checkDB() {
        Handler(Looper.getMainLooper()).post {
            db?.imagesDAO()?.insert(ImageDBModel(id = -1, title = "test", date = "now", address = ""))
            db?.imagesDAO()?.getAllImages()?.observeForever {
                if (it.isEmpty())
                    fail("Database is empty!")
            }
        }
    }

    @After
    fun removeTests() {
        db?.imagesDAO()?.deleteByID(-1)
    }
}
