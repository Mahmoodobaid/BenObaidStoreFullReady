package com.benobaidstore.utils

import android.content.Context
import android.content.Intent
import com.benobaidstore.model.Product

object ShareUtils {
    fun shareProduct(context: Context, product: Product) {
        val shareText = """
            اسم المنتج: ${'$'}{product.name}
            النوع: ${'$'}{product.type}
            الوصف: ${'$'}{product.description}
            السعر: ${'$'}{product.price} ${'$'}{product.currency}
        """.trimIndent()

        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }

        context.startActivity(Intent.createChooser(intent, "مشاركة المنتج عبر"))
    }
}