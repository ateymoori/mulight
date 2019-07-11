package com.mulight.repo

import android.content.Context
import androidx.lifecycle.LiveData
import com.mulight.utils.bases.PublicMethods
import com.mulight.utils.entities.ImageDBModel
import com.mulight.utils.entities.ImageModel
import com.mulight.utils.entities.ImageSaveResultModel
import com.mulight.utils.enums.SavePhotoResult
import io.reactivex.Observable

class MainRepository {

    companion object {
        fun savePhoto(imageData: ImageModel, mContext: Context): Observable<ImageSaveResultModel> {
            return Observable.fromCallable {
               // PublicMethods.saveToInternalStorage(mContext, imageData.image).also {
                    savePhotoDetailsToDB(imageData.name, imageData.date, imageData.image.absolutePath)
              //  }
            }
        }

        private fun savePhotoDetailsToDB(title: String, date: String, address: String?):ImageSaveResultModel {
            return if (address != null) {
                val dbRepo = DBRepository()
                dbRepo.insertImage(ImageDBModel(title = title, date = date, address = address))
                ImageSaveResultModel(result = SavePhotoResult.SAVED, address = address)
            }else{
                ImageSaveResultModel(result = SavePhotoResult.ERROR, address = null)
            }
        }

        fun getAllPhotos(): LiveData<List<ImageDBModel>> = DBRepository().getImages()
    }

}