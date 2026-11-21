package com.example.projek_arkan

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.projek_arkan.data.AppDatabase
import com.example.projek_arkan.data.entity.BukuTersimpanEntity
import com.example.projek_arkan.databinding.ActivityDetailBukuBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch

class DetailBukuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBukuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbarDetail.navigationIcon?.setTint(getColor(R.color.navy))
        binding.toolbarDetail.setNavigationOnClickListener {
            finish()
        }

        // 1. Ambil data buku yang dikirim dari BerandaFragment
        val judul = intent.getStringExtra("EXTRA_JUDUL") ?: "Tanpa Judul"
        val penulis = intent.getStringExtra("EXTRA_PENULIS") ?: "Tanpa Penulis"
        val cover = intent.getIntExtra("EXTRA_COVER", R.drawable.encyclopedia_of_science_cover)


        binding.JudulDetail.text = judul
        binding.PenulisDetail.text = penulis
        binding.CoverDetail.setImageResource(cover)


        binding.btnUnduh.setOnClickListener {
            tampilkanDialogSimpan(judul, penulis, cover)
        }
    }

    private fun tampilkanDialogSimpan(judul: String, penulis: String, cover: Int) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Simpan Buku")
            .setMessage("Unduh dan tambahkan '$judul' ke daftar Tersimpan?")
            .setPositiveButton("Simpan") { _, _ ->
                val db = AppDatabase.getInstance(this)
                lifecycleScope.launch {
                    val entity = BukuTersimpanEntity(
                        judul = judul,
                        penulis = penulis,
                        cover = cover
                    )
                    db.bukuTersimpanDao().insert(entity)
                    Toast.makeText(
                        this@DetailBukuActivity,
                        "Buku berhasil disimpan!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            .setNegativeButton("Batal", null)
            .show()
    }
}