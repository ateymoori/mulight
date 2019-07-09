package com.mulight.ui.take_photo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mulight.R
import android.provider.MediaStore
import android.content.Intent
import com.mulight.utils.bases.Cons.Companion.CAMERA_PERMISSION
import com.mulight.utils.bases.permissionGranted
import com.mulight.utils.bases.requestPermission
import android.graphics.Bitmap
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mulight.utils.entities.ImageModel
import com.mulight.utils.enums.SavePhotoResult
import kotlinx.android.synthetic.main.fragment_take_photo.*

class TakePhotoFragment : Fragment() {
    private var viewModel: TakePhotoViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TakePhotoViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        checkPermission()
        return inflater.inflate(R.layout.fragment_take_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        checkPermission()
    }

    private fun checkPermission() {
        if (activity?.permissionGranted(CAMERA_PERMISSION) == true)
            openCamera()
        else
            activity?.requestPermission(CAMERA_PERMISSION, 100)
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(
            intent,
            1000
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val extras = data?.extras
        val imageBitmap = extras?.get("data") as Bitmap?
        img.setImageBitmap(imageBitmap)
    }

    private fun savePhoto(img: Bitmap) {
        val date = "2019-01-01"
        val name = "sample name"
        val data = ImageModel(image = img, name = name, date = date)
        viewModel?.storePhoto(data)?.observe(this, Observer { onStorePhotoResult(it) })
    }

    private fun onStorePhotoResult(result: SavePhotoResult) {

    }
}
