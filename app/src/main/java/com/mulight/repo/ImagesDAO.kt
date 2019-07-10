package com.mulight.repo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mulight.utils.entities.ImageDBModel

@Dao
interface ImagesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(image: ImageDBModel)

    @Query("DELETE FROM images")
    fun deleteAll()

    @Query("SELECT * FROM images")
    fun getAllImages(): LiveData<List<ImageDBModel>>





}