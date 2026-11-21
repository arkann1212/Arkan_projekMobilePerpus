package com.example.projek_arkan.Tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projek_arkan.BukuTersimpanAdapter
import com.example.projek_arkan.data.AppDatabase
import com.example.projek_arkan.data.entity.BukuTersimpanEntity
import com.example.projek_arkan.databinding.FragmentTersimpanBinding
import kotlinx.coroutines.launch

class TersimpanFragment : Fragment() {
    private var _binding: FragmentTersimpanBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: AppDatabase
    private lateinit var adapter: BukuTersimpanAdapter
    private val listBuku = mutableListOf<BukuTersimpanEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTersimpanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = AppDatabase.getInstance(requireContext())
        adapter = BukuTersimpanAdapter(listBuku) { buku -> deleteBuku(buku) }

        binding.rvTersimpan.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTersimpan.adapter = adapter
        binding.rvTersimpan.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )
    }

    override fun onResume() {
        super.onResume()
        if (_binding != null) fetchBukuTersimpan()
    }

    private fun fetchBukuTersimpan() {
        viewLifecycleOwner.lifecycleScope.launch {
            val result = db.bukuTersimpanDao().getAll()
            listBuku.clear()
            listBuku.addAll(result)
            adapter.notifyDataSetChanged()
        }
    }

    private fun deleteBuku(buku: BukuTersimpanEntity) {
        viewLifecycleOwner.lifecycleScope.launch {
            db.bukuTersimpanDao().delete(buku)
            fetchBukuTersimpan()
        }
    }

    override fun onDestroyView() {
        binding.rvTersimpan.adapter = null
        _binding = null
        super.onDestroyView()
    }
}