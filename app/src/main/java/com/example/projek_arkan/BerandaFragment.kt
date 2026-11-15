package com.example.projek_arkan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projek_arkan.RecyclerView.BukuHorizontalAdapter
import com.example.projek_arkan.RecyclerView.BukuVertikalAdapter
import com.example.projek_arkan.databinding.FragmentBerandaBinding

class BerandaFragment : Fragment() {
    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Data untuk RecyclerView Horizontal (Judul Baru)
        val daftarJudulBaru = listOf(
            BukuModel(
                R.drawable.encyclopedia_of_science_cover,
                "Encyclopedia Of Science",
                "DK Publishing"
            ),
            BukuModel(R.drawable.filsafat_sains_cover, "Filsafat Sains", "Jerome R. Ravertz"),
            BukuModel(R.drawable.book_of_proof_cover, "Geografi Indonesia", "Budi Susilo"),
            BukuModel(R.drawable.the_maths_magic_cover, "The Maths Book", "Clifford A. Pickover")
        )

        // 2. Hubungkan data ke Adapter Horizontal yang baru kita buat
        val adapterHorizontal = BukuHorizontalAdapter(daftarJudulBaru) { buku ->
            Toast.makeText(
                requireContext(),
                "Memilih: ${buku.judul}",
                Toast.LENGTH_SHORT
            ).show()
        }

        // 3. Pasang adapter ke RecyclerView Horizontal di layout
        binding.rvJudulBaru.adapter = adapterHorizontal

        val daftarRekomendasi = listOf(
            BukuModel(R.drawable.the_maths_magic_cover, "The Maths Book", "Clifford A. Pickover"),
            BukuModel(R.drawable.book_of_proof_cover, "Geografi Indonesia", "Budi Susilo"),
            BukuModel(
                R.drawable.encyclopedia_of_science_cover,
                "Encyclopedia Of Science",
                "DK Publishing"
            ),
            BukuModel(R.drawable.filsafat_sains_cover, "Filsafat Sains", "Jerome R. Ravertz")
        )

        val adapterVertikal = BukuVertikalAdapter(daftarRekomendasi) { buku ->
            Toast.makeText(
                requireContext(),
                "Rekomendasi: ${buku.judul}",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.rvRekomendasi.adapter = adapterVertikal
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
