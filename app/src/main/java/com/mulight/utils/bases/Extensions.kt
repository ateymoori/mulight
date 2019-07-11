package com.mulight.utils.bases

import android.app.Activity
import android.content.pm.PackageManager
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

fun Activity.permissionGranted(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}

fun Activity.requestPermission(permission: String, code: Int) {
    ActivityCompat.requestPermissions(this, arrayOf(permission), code);
}
fun Activity.requestGroupPermission(permissions:  Array<String>, code: Int) {
    ActivityCompat.requestPermissions(this, permissions, code);
}


fun String.toast() {
    Toast.makeText(MyApplication.instance, this, Toast.LENGTH_SHORT).show()
}

fun <T : androidx.recyclerview.widget.RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(adapterPosition, itemViewType)
    }
    return this
}

fun ImageView.loadFromURL(url: String?) {
    MyApplication.instance?.applicationContext?.let {
        Glide.with(it)
            .load(url)
            .into(this)
    }
}

