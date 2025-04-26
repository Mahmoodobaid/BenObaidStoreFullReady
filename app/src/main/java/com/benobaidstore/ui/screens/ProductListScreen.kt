package com.benobaidstore.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.benobaidstore.viewmodel.ProductViewModel
import com.benobaidstore.utils.ShareUtils

@Composable
fun ProductListScreen(viewModel: ProductViewModel = viewModel()) {
    val products by viewModel.products.collectAsState()
    val context = LocalContext.current

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(products) { product ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("الاسم: ${'$'}{product.name}", style = MaterialTheme.typography.titleMedium)
                    Text("الوصف: ${'$'}{product.description}")
                    Text("السعر: ${'$'}{product.price} ${'$'}{product.currency}")
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Button(onClick = { ShareUtils.shareProduct(context, product) }) {
                            Text("مشاركة")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = { viewModel.deleteProduct(product) }) {
                            Text("حذف")
                        }
                    }
                }
            }
        }
    }
}