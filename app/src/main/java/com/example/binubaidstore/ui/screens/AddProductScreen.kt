package com.example.binubaidstore.ui.screens



import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.benobaidstore.viewmodel.ProductViewModel

@Composable
fun AddProductScreen(viewModel: ProductViewModel = viewModel()) {
    var type by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var currency by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        TextField(value = type, onValueChange = { type = it }, label = { Text("نوع المنتج") })
        Spacer(Modifier.height(8.dp))
        TextField(value = name, onValueChange = { name = it }, label = { Text("اسم المنتج") })
        Spacer(Modifier.height(8.dp))
        TextField(value = description, onValueChange = { description = it }, label = { Text("الوصف") })
        Spacer(Modifier.height(8.dp))
        TextField(value = price, onValueChange = { price = it }, label = { Text("السعر") })
        Spacer(Modifier.height(8.dp))
        TextField(value = currency, onValueChange = { currency = it }, label = { Text("العملة") })
        Spacer(Modifier.height(16.dp))

        Button(onClick = { viewModel.addProduct() }, Modifier.fillMaxWidth()) {
            Text("حفظ المنتج")
        }
    }
}