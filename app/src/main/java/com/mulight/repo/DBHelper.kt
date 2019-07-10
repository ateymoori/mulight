package com.mulight.repo

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mulight.utils.bases.Cons
import com.mulight.utils.bases.MyApplication
import com.mulight.utils.entities.ImageDBModel

@Database(entities = [ImageDBModel::class], version = 1)
abstract class DBHelper : RoomDatabase() {

    abstract fun imagesDAO(): ImagesDAO

    companion object {
        private var INSTANCE: DBHelper? = null

        //get singleton to avoid multi instance of DB
        fun getInstance( ): DBHelper? {
            if (INSTANCE == null) {
                synchronized(DBHelper::class) {
                    INSTANCE = MyApplication.instance?.applicationContext?.let {
                        Room.databaseBuilder(
                            it,
                            DBHelper::class.java, Cons.DB_NAME)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}