package com.mulight.ui.take_photo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.provider.MediaStore
import android.content.Intent
import com.mulight.utils.bases.Cons.Companion.CAMERA_PERMISSION
import android.os.Environment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.mulight.utils.enums.SavePhotoResult
import kotlinx.android.synthetic.main.fragment_take_photo.*
import com.mulight.utils.bases.*
import com.mulight.utils.bases.Cons.Companion.FILE_PERMISSION
import java.io.File
import com.mulight.R
import androidx.core.content.FileProvider
import android.content.Context
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.mulight.BuildConfig
import com.mulight.utils.entities.ImageModel
import java.io.IOException


class TakePhotoFragment : Fragment() {
    private var mPhotoFile: File? = null
    private val PERMISSION_CODE = 1000
    private val CAMERA_REQUEST_CODE = 2000
    private var viewModel: TakePhotoViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TakePhotoViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        takePhoto()
        return inflater.inflate(R.layout.fragment_take_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        takeAgain.setOnClickListener { takePhoto() }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        takePhoto()
    }

    private fun takePhoto() {
        if (activity?.permissionGranted(FILE_PERMISSION) == false || activity?.permissionGranted(FILE_PERMISSION) == false) {
            activity?.requestGroupPermission(arrayOf(CAMERA_PERMISSION, FILE_PERMISSION), PERMISSION_CODE)
            return
        }
        openCamera()
    }


    private fun createImageFile(): File {
        val mFileName = PublicMethods.getUnixTime().toString()
        val storageDir = activity?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(mFileName, ".jpg", storageDir)
    }

    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (getCTX()?.packageManager?.let { takePictureIntent.resolveActivity(it) } != null) {
            var photoFile: File? = null
            try {
                photoFile = createImageFile()
            } catch (ex: IOException) {
                ex.printStackTrace()
            }

            if (photoFile != null) {
                val photoURI = getCTX()?.let {
                    FileProvider.getUriForFile(
                        it,
                        BuildConfig.APPLICATION_ID + ".provider",
                        photoFile
                    )
                }

                mPhotoFile = photoFile
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE)

            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        activity?.let { Glide.with(it).load(mPhotoFile).into(img) }
        save.setOnClickListener { savePhoto(mPhotoFile) }

    }

    private fun savePhoto(mPhotoFile: File?) {
        when {
            mPhotoFile == null -> {
                getString(R.string.take_a_photo).toast()
                return
            }
            photoTitle.text.isEmpty() -> {
                photoTitle.error = getString(R.string.enter_title)
                return
            }
            else -> {
                val data = ImageModel(
                    image = mPhotoFile,
                    name = photoTitle.text.toString(),
                    date = PublicMethods.getSystemDateTime()
                )
                viewModel?.storePhoto(data, activity)?.observe(this, Observer { onStorePhotoResult(it) })
            }
        }
    }

    private fun onStorePhotoResult(result: SavePhotoResult) {
        when (result) {
            SavePhotoResult.SAVED -> {
                getString(R.string.saved).toast()
                Navigation.findNavController(save).popBackStack()
            }
            SavePhotoResult.ERROR -> {
                getString(R.string.error).toast()
            }
        }
    }
    private fun getCTX(): Context? {
        return activity ?: MyApplication.instance?.applicationContext
    }

}
