package com.example.projek_arkan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        val daftarJudulBaru = listOf(
            BukuModel(R.drawable.encyclopedia_of_science_cover, "Encyclopedia Of Science", "DK Publishing"),
            BukuModel(R.drawable.filsafat_sains_cover, "Filsafat Sains", "Jerome R. Ravertz"),
            BukuModel(R.drawable.book_of_proof_cover, "Geografi Indonesia", "Budi Susilo"),
            BukuModel(R.drawable.the_maths_magic_cover, "The Maths Book", "Clifford A. Pickover")
        )

        val adapterHorizontal = BukuHorizontalAdapter(daftarJudulBaru) { buku ->
            bukaDetailBuku(buku)
        }
        binding.rvJudulBaru.adapter = adapterHorizontal

        val daftarRekomendasi = listOf(
            BukuModel(R.drawable.the_maths_magic_cover, "The Maths Book", "Clifford A. Pickover"),
            BukuModel(R.drawable.book_of_proof_cover, "Geografi Indonesia", "Budi Susilo"),
            BukuModel(R.drawable.encyclopedia_of_science_cover, "Encyclopedia Of Science", "DK Publishing"),
            BukuModel(R.drawable.filsafat_sains_cover, "Filsafat Sains", "Jerome R. Ravertz")
        )

        val adapterVertikal = BukuVertikalAdapter(daftarRekomendasi) { buku ->
            bukaDetailBuku(buku)
        }
        binding.rvRekomendasi.adapter = adapterVertikal
    }

    private fun bukaDetailBuku(buku: BukuModel) {
        val intent = Intent(requireContext(), DetailBukuActivity::class.java).apply {
            putExtra("EXTRA_JUDUL", buku.judul)
            putExtra("EXTRA_PENULIS", buku.penulis)
            putExtra("EXTRA_COVER", buku.cover)
        }
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}