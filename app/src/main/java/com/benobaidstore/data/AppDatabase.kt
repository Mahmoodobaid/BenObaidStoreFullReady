package com.benobaidstore.data

import android.content.Context
import androidx.room.*
import com.benobaidstore.model.Product
import com.benobaidstore.utils.Converters

@Database(entities = [Product::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "products_db"
                ).build().also { instance = it }
            }
    }
}