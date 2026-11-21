package com.example.projek_arkan.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.projek_arkan.data.entity.BukuTersimpanEntity

@Dao
interface BukuTersimpanDao {
    @Query("SELECT * FROM buku_tersimpan ORDER BY waktuSimpan DESC")
    suspend fun getAll(): List<BukuTersimpanEntity>

    @Insert
    suspend fun insert(buku: BukuTersimpanEntity)

    @Delete
    suspend fun delete(buku: BukuTersimpanEntity)
}