package com.example.binubaidstore.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.binubaidstore.data.AppDatabase
import com.example.binubaidstore.model.Product
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getDatabase(application).productDao()

    val products: StateFlow<List<Product>> = dao.getAllProducts()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addProduct() {
        viewModelScope.launch {
            val product = Product(
                type = "حديد",
                name = "سيخ حديد 16 ملم",
                description = "أعلى جودة تصنيع سعودي",
                price = 20000.0,
                currency = "ريال يمني",
                imagePaths = emptyList()
            )
            dao.insert(product)
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            dao.delete(product)
        }
    }
}
