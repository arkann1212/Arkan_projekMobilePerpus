package com.example.projek_arkan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projek_arkan.databinding.ActivityBerandaBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class BerandaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBerandaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBerandaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarBeranda)

        binding.cvBukuPilihan.setOnClickListener {
            startActivity(Intent(this, DetailBukuActivity::class.java))
        }

        binding.btnDetail.setOnClickListener {
            startActivity(Intent(this, DetailBukuActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Iya") { dialog, _ ->
                    val sharedPref = getSharedPreferences("DigiPerpusPrefs", Context.MODE_PRIVATE)
                    sharedPref.edit().clear().apply()

                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}