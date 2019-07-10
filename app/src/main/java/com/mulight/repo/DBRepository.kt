package com.mulight.repo

import androidx.lifecycle.LiveData
import com.mulight.utils.entities.ImageDBModel

class DBRepository {

    private var imagesDAO: ImagesDAO
    private var allImages: LiveData<List<ImageDBModel>>

    init {
        val db = DBHelper.getInstance()
        imagesDAO = db?.imagesDAO()!!
        allImages = imagesDAO.getAllImages()
    }

    fun getImages(): LiveData<List<ImageDBModel>> {
        return allImages
    }

    fun insertImage(img:ImageDBModel){
        imagesDAO.insert(img)
    }


}