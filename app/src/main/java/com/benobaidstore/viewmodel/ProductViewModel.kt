package com.benobaidstore.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.benobaidstore.data.AppDatabase
import com.benobaidstore.model.Product
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).productDao()

    val products: StateFlow<List<Product>> = dao.getAllProducts()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addProduct(product: Product) {
        viewModelScope.launch {
            dao.insert(product)
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            dao.delete(product)
        }
    }
}