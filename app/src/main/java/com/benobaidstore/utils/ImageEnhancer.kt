package com.benobaidstore.utils

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

object ImageEnhancer {
    fun enhanceImage(bitmap: Bitmap): Bitmap {
        val output = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        val canvas = Canvas(output)
        val paint = Paint().apply {
            isAntiAlias = true
            colorFilter = null
        }

        // خلفية بيضاء
        canvas.drawColor(Color.WHITE)
        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        // تأثير بسيط لتوضيح الصورة
        paint.alpha = 220
        canvas.drawBitmap(output, 0f, 0f, paint)

        return output
    }
}