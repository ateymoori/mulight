package com.mulight.ui.take_photo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mulight.utils.entities.ImageModel
import com.mulight.utils.enums.SavePhotoResult

class TakePhotoViewModel:ViewModel() {


    fun storePhoto(img:ImageModel):LiveData<SavePhotoResult>{
        val result = MutableLiveData<SavePhotoResult>()

        result.value = SavePhotoResult.SAVED

        return result

    }


}