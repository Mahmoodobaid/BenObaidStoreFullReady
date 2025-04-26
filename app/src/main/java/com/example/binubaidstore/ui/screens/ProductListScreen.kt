package com.example.binubaidstore.ui.screens



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.benobaidstore.viewmodel.ProductViewModel

@Composable
fun ProductListScreen(viewModel: ProductViewModel = viewModel()) {
    val products by viewModel.products.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("متجر بن عبيد") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.addProduct() }) {
                Text("+")
            }
        }
    ) {
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            items(products.size) { index ->
                val product = products[index]
                Text(product.name)
            }
        }
    }
}