package com.example.projek_arkan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.projek_arkan.databinding.ActivityBerandaBinding

class BerandaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBerandaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBerandaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(BerandaFragment()) // Tampilan awal

        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_beranda -> replaceFragment(BerandaFragment())
                R.id.nav_katalog -> replaceFragment(KatalogFragment())
                R.id.nav_notifikasi -> replaceFragment(NotifikasiFragment())
                R.id.nav_profil -> replaceFragment(ProfilFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
// TAMBAHIN MAPS