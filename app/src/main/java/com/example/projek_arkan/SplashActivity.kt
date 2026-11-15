package com.example.projek_arkan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.projek_arkan.databinding.ActivitySplashBinding
import com.example.projek_arkan.tutorial.TutorialActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val sharedPref = getSharedPreferences("DigiPerpusPrefs", Context.MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("is_login", false)

            if (isLogin) {
                startActivity(Intent(this, BerandaActivity::class.java))
            } else {
                startActivity(Intent(this, TutorialActivity::class.java))
            }
            finish()
        }, 2000)
    }
}