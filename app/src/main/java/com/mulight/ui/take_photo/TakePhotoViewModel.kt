package com.mulight.ui.take_photo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mulight.repo.MainRepository
import com.mulight.utils.entities.ImageModel
import com.mulight.utils.enums.SavePhotoResult

class TakePhotoViewModel : ViewModel() {


    fun storePhoto(imageData: ImageModel, mContext: Context?): LiveData<SavePhotoResult> {
        val result = MutableLiveData<SavePhotoResult>()
        mContext?.let {
            MainRepository.savePhoto(imageData, it).subscribe { img ->
                result.value = img.result
            }
        }
        return result
    }

}