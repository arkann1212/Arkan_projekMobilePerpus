package com.example.projek_arkan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projek_arkan.databinding.ActivityDetailBukuBinding

class DetailBukuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBukuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbarDetail.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}