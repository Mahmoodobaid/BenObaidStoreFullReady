package com.benobaidstore.utils

import android.content.Context
import android.util.Log
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.client.googleapis.media.MediaHttpDownloader
import com.google.api.client.googleapis.media.MediaHttpDownloaderProgressListener
import com.google.api.client.http.FileContent
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.drive.Drive
import com.google.api.services.drive.model.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.Collections

object DriveSyncUtils {

    private var driveService: Drive? = null

    fun initDriveService(context: Context, accountName: String) {
        val credential = GoogleAccountCredential.usingOAuth2(
            context,
            Collections.singleton("https://www.googleapis.com/auth/drive.appdata")
        )
        credential.selectedAccountName = accountName
        driveService = Drive.Builder(
            AndroidHttp.newCompatibleTransport(),
            GsonFactory(),
            credential
        ).setApplicationName("BenObaidStore").build()
    }

    fun uploadDatabase(context: Context) {
        try {
            val dbFile = context.getDatabasePath("products_db")
            if (!dbFile.exists()) {
                Log.e("DriveSync", "Database file not found.")
                return
            }

            val fileMetadata = File()
            fileMetadata.name = "products_db_backup"
            fileMetadata.parents = listOf("appDataFolder")

            val mediaContent = FileContent("application/octet-stream", dbFile)
            val file = driveService?.files()?.create(fileMetadata, mediaContent)
                ?.setFields("id")
                ?.execute()

            Log.i("DriveSync", "Database uploaded to Drive with ID: " + file?.id)
        } catch (e: IOException) {
            Log.e("DriveSync", "Upload failed: $e")
        }
    }

    fun restoreDatabase(context: Context) {
        try {
            val result = driveService?.files()?.list()
                ?.setSpaces("appDataFolder")
                ?.setQ("name='products_db_backup'")
                ?.setFields("files(id, name)")
                ?.execute()

            val file = result?.files?.firstOrNull()
            if (file != null) {
                val dbFile = context.getDatabasePath("products_db")
                val outputStream = FileOutputStream(dbFile)

                driveService?.files()?.get(file.id)
                    ?.executeMediaAndDownloadTo(outputStream)

                Log.i("DriveSync", "Database restored from Drive")
            } else {
                Log.i("DriveSync", "No backup found on Drive")
            }
        } catch (e: IOException) {
            Log.e("DriveSync", "Restore failed: $e")
        }
    }
}