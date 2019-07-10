package com.mulight.utils.bases

import android.app.Activity
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

fun Activity.permissionGranted(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}

fun Activity.requestPermission(permission: String, code: Int) {
    ActivityCompat.requestPermissions(this, arrayOf(permission), code);
}


fun String.toast() {
    Toast.makeText(MyApplication.instance, this, Toast.LENGTH_SHORT).show()
}