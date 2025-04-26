package com.benobaidstore.utils

import android.content.Context
import android.net.Uri
import android.os.Environment
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

object FileUtils {
    fun createImageFile(context: Context): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir: File = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        return File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir)
    }

    fun getFileUri(context: Context, file: File): Uri =
        androidx.core.content.FileProvider.getUriForFile(context, context.packageName + ".provider", file)
}