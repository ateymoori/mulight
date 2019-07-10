package com.mulight.ui.dashboard

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.mulight.repo.DBRepository
import com.mulight.repo.MainRepository
import com.mulight.utils.entities.ImageDBModel
import com.mulight.utils.entities.ImageModel
import com.mulight.utils.enums.SavePhotoResult

class DashboardViewModel : ViewModel() {

    fun getAllPhotos(): LiveData<List<ImageDBModel>> = MainRepository.getAllPhotos()



    fun storePhoto(imageData: ImageModel, mContext: Context?): LiveData<SavePhotoResult> {
        val result = MutableLiveData<SavePhotoResult>()
        val disposable = mContext?.let {
            MainRepository.savePhoto(imageData, it).subscribe { img ->
                result.value = img.result
            }
        }
        return result

    }


}