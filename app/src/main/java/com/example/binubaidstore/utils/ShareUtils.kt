package com.example.binubaidstore.utils


import android.content.Context
import com.example.binubaidstore.model.Product
import android.content.Intent as Intent1

object ShareUtils {
    fun shareProduct(context: Context, product: Product) {
        val shareIntent = Intent1(Intent1.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(
            Intent1.EXTRA_TEXT,
            "منتج: ${product.name}\n" +
                    "النوع: ${product.type}\n" +
                    "الوصف: ${product.description}\n" +
                    "السعر: ${product.price} ${product.currency}"
        )
        context.startActivity(Intent1.createChooser(shareIntent, "مشاركة المنتج عبر"))
    }
}