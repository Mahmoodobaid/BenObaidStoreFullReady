package com.benobaidstore.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.benobaidstore.model.Product
import com.benobaidstore.utils.ImageEnhancer
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.toArgb

@Composable
fun AddProductScreen() {
    val context = LocalContext.current
    var name by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var price by rememberSaveable { mutableStateOf("") }
    var currency by rememberSaveable { mutableStateOf("ريال") }

    var imageBitmap by remember { mutableStateOf<Bitmap?>(null) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("اسم المنتج") })
        OutlinedTextField(value = description, onValueChange = { description = it }, label = { Text("الوصف") })
        OutlinedTextField(value = price, onValueChange = { price = it }, label = { Text("السعر") })

        Spacer(modifier = Modifier.height(12.dp))

        imageBitmap?.let {
            Image(bitmap = it.asImageBitmap(), contentDescription = "صورة المنتج", modifier = Modifier.height(200.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            // محاكاة تحميل صورة من الموارد وتحسينها
            val original = BitmapFactory.decodeResource(context.resources, android.R.drawable.ic_menu_camera)
            imageBitmap = ImageEnhancer.enhanceImage(original)
        }) {
            Text("تحسين الصورة")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // هنا يتم حفظ المنتج، الكود الفعلي يجب ربطه بـ ViewModel
        }) {
            Text("إضافة المنتج")
        }
    }
}