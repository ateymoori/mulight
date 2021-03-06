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

    @Query("SELECT * FROM images order by id desc")
    fun getAllImages(): LiveData<List<ImageDBModel>>

    @Query(
        "DELETE FROM images " +
                "WHERE id = :id"
    )
    fun deleteByID(id: Long)


}