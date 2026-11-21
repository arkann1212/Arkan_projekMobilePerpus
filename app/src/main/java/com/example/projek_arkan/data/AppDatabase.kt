package com.example.projek_arkan.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projek_arkan.data.dao.BukuTersimpanDao
import com.example.projek_arkan.data.entity.BukuTersimpanEntity

@Database(
    entities = [BukuTersimpanEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bukuTersimpanDao(): BukuTersimpanDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "digiperpus_database"
                ).build().also { INSTANCE = it }
            }
    }
}