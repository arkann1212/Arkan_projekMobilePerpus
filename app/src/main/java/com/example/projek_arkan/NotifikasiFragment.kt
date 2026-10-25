package com.example.projek_arkan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import com.example.projek_arkan.databinding.FragmentNotifikasiBinding

class NotifikasiFragment : Fragment() {
    private var _binding: FragmentNotifikasiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNotifikasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataNotif = ArrayList<HashMap<String, String>>()

        val notif1 = HashMap<String, String>()
        notif1["title"] = "Rilis Baru!"
        notif1["desc"] = "Buku 'The Algorithm' edisi revisi sudah rilis."
        dataNotif.add(notif1)

        val notif2 = HashMap<String, String>()
        notif2["title"] = "Unduhan Selesai!"
        notif2["desc"] = "Buku 'The Maths Magic' siap dibaca."
        dataNotif.add(notif2)

        val adapter = SimpleAdapter(
            requireContext(), dataNotif, android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"), intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        binding.listViewNotifikasi.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}