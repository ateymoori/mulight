package com.mulight.repo

import android.content.Context
import androidx.lifecycle.LiveData
import com.mulight.utils.bases.PublicMethods
import com.mulight.utils.entities.ImageDBModel
import com.mulight.utils.entities.ImageModel
import com.mulight.utils.entities.ImageSaveResultModel
import io.reactivex.Observable

class MainRepository {

    companion object {
        fun savePhoto(imageData: ImageModel, mContext: Context): Observable<ImageSaveResultModel> {
            return Observable.fromCallable {
                PublicMethods.saveToInternalStorage(mContext, imageData.image).also {
                    savePhotoDetailsToDB(imageData.name, imageData.date, it.address)
                }
            }
        }

        private fun savePhotoDetailsToDB(title: String, date: String, address: String?) {
            if (address != null) {
                val dbRepo = DBRepository()
                dbRepo.insertImage(ImageDBModel(title = title, date = date, address = address))
            }
        }

        fun getAllPhotos(): LiveData<List<ImageDBModel>> = DBRepository().getImages()
    }

}