package com.mulight.ui.image_viewer

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.mulight.R
import com.mulight.utils.bases.loadFromURL
import com.mulight.utils.entities.ImageDBModel
import kotlinx.android.synthetic.main.activity_image_viewer.*

class FullScreenImageViewerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_image_viewer)

        val image: ImageDBModel = intent.getParcelableExtra("image")
        imageView.loadFromURL(image.address)
        date.text = image.date
        imageTitle.text = image.title

        toggleToolbar()
        back.setOnClickListener { onBackPressed() }
        imageView.setOnClickListener {
            toggleToolbar()
        }
    }
    private fun toggleToolbar(){
        showToolbar(true)
        Handler().postDelayed({showToolbar(false)},2000)
    }

    private fun showToolbar(show: Boolean) {
        var visibility = View.VISIBLE
        if (!show) visibility = View.GONE
        topBar.visibility = visibility
        bottomBar.visibility = visibility
    }
}