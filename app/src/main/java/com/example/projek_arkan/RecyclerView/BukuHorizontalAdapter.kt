package com.example.projek_arkan.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projek_arkan.BukuModel
import com.example.projek_arkan.R

class BukuHorizontalAdapter(
    private val listBuku: List<BukuModel>,
    private val onItemClick: (BukuModel) -> Unit
) : RecyclerView.Adapter<BukuHorizontalAdapter.BukuViewHolder>() {

    inner class BukuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgBuku: ImageView = itemView.findViewById(R.id.imgBuku)
        val tvJudulBuku: TextView = itemView.findViewById(R.id.tvJudulBuku)

        fun bind(buku: BukuModel) {
            // Mengambil data sesuai dengan variabel di BukuModel.kt milikmu
            tvJudulBuku.text = buku.judul
            imgBuku.setImageResource(buku.cover)

            itemView.setOnClickListener { onItemClick(buku) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_buku_horizontal, parent, false)
        return BukuViewHolder(view)
    }

    override fun onBindViewHolder(holder: BukuViewHolder, position: Int) {
        holder.bind(listBuku[position])
    }

    override fun getItemCount(): Int = listBuku.size
}