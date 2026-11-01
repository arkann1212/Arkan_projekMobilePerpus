package com.example.projek_arkan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projek_arkan.databinding.FragmentProfilBinding
import com.example.projek_arkan.tutorial.TutorialActivity

class ProfilFragment : Fragment() {
    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKeluar.setOnClickListener {
            // Hapus sesi login
            val sharedPref = requireActivity().getSharedPreferences("DigiPerpusPrefs", Context.MODE_PRIVATE)
            sharedPref.edit().clear().apply()

            // Kembali ke halaman Login
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish()
        }

        // Memberikan aksi klik pada tombol tutorial
        binding.btnLihatTutorial.setOnClickListener {
            val intent = Intent(requireContext(), TutorialActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}