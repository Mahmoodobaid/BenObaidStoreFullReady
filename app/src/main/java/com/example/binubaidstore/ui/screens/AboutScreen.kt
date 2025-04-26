package com.example.binubaidstore.ui.screens
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("حول التطبيق", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(8.dp))
        Text("محلات بن عبيد التجارية - مواد البناء والكهرباء والسباكة والطلاء.")
        Spacer(modifier = Modifier.height(8.dp))
        Text("العنوان: اليمن - إب - شارع المحافظة")
        Spacer(modifier = Modifier.height(8.dp))
        Text("مبيعات: 782999654")
        Text("حسابات: 782999652")
        Text("مبيعات جملة: 782999653")
        Text("واتساب: +967770491653")
    }
}