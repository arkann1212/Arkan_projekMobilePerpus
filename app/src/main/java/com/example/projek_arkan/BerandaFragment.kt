package com.example.projek_arkan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projek_arkan.databinding.FragmentBerandaBinding

class BerandaFragment : Fragment() {
    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val daftarBuku = listOf(
            BukuModel(R.drawable.the_maths_magic_cover, "The Maths Magic", "Bilingual"),
            BukuModel(R.drawable.book_of_proof_cover, "Book Of Proof", "Richard Hammack"),
            BukuModel(R.drawable.the_algorithm_cover, "The Algorithm", "Sedgewick"),
            BukuModel(R.drawable.the_maths_magic_cover, "The Maths Magic", "Bilingual")
        )

        val adapter = BukuAdapter(requireContext(), daftarBuku)
        binding.listViewBuku.adapter = adapter

        // Logika klik sudah dipindah secara aman ke dalam BukuAdapter.kt
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}