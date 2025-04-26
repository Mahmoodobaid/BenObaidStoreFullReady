package com.example.binubaidstore.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: String,
    val name: String,
    val description: String,
    val price: Double,
    val currency: String,
    val imagePaths: List<String> // مسارات الصور
)