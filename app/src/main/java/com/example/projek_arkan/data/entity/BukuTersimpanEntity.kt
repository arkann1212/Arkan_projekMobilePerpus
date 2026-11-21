package com.example.projek_arkan.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buku_tersimpan")
data class BukuTersimpanEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val judul: String,
    val penulis: String,
    val cover: Int,
    val waktuSimpan: Long = System.currentTimeMillis()
)