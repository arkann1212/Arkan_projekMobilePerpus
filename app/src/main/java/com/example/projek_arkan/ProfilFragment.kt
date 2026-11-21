package com.example.projek_arkan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projek_arkan.databinding.FragmentProfilBinding
import com.google.android.material.tabs.TabLayoutMediator

class ProfilFragment : Fragment() {
    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val tabsAdapter = ProfilTabsAdapter(this)


        binding.viewPagerProfil.adapter = tabsAdapter


        TabLayoutMediator(binding.tabLayoutProfil, binding.viewPagerProfil) { tab, position ->
            when (position) {
                0 -> tab.text = "Riwayat Baca"
                1 -> tab.text = "Tersimpan"
            }
        }.attach()


        binding.btnKeluar.setOnClickListener {
            // Hapus status login di memori HP agar Splash Screen tahu kita sudah keluar
            val sharedPref = requireActivity().getSharedPreferences("DigiPerpusPrefs", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putBoolean("is_login", false) // Set kembali menjadi false
                apply()
            }

            // Pindah ke LoginActivity dan bersihkan tumpukan halaman
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}