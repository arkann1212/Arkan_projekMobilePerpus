package com.example.projek_arkan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projek_arkan.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {

                if (username == password) {

                    val sharedPref = getSharedPreferences("DigiPerpusPrefs", Context.MODE_PRIVATE)
                    sharedPref.edit().putBoolean("is_login", true).apply()

                    val intent = Intent(this, BerandaActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            } else {
                Toast.makeText(this, "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}