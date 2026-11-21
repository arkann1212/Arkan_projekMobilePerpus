package com.example.projek_arkan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projek_arkan.data.entity.BukuTersimpanEntity
import com.example.projek_arkan.databinding.ItemBukuTersimpanBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class BukuTersimpanAdapter(
    private val listBuku: List<BukuTersimpanEntity>,
    private val onDelete: (BukuTersimpanEntity) -> Unit
) : RecyclerView.Adapter<BukuTersimpanAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemBukuTersimpanBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBukuTersimpanBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val buku = listBuku[position]
        holder.binding.tvJudulTersimpan.text = buku.judul
        holder.binding.tvPenulisTersimpan.text = buku.penulis
        holder.binding.imgCoverTersimpan.setImageResource(buku.cover)

        holder.binding.btnDelete.setOnClickListener {
            MaterialAlertDialogBuilder(holder.itemView.context)
                .setTitle("Hapus Buku")
                .setMessage("Yakin ingin menghapus '${buku.judul}' dari Tersimpan?")
                .setPositiveButton("Ya") { _, _ -> onDelete(buku) }
                .setNegativeButton("Batal", null)
                .show()
        }
    }

    override fun getItemCount(): Int = listBuku.size
}