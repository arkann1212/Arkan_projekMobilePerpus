package com.example.projek_arkan.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projek_arkan.BukuModel
import com.example.projek_arkan.R

class BukuVertikalAdapter(
    private val listBuku: List<BukuModel>,
    private val onItemClick: (BukuModel) -> Unit
) : RecyclerView.Adapter<BukuVertikalAdapter.BukuViewHolder>() {

    inner class BukuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgBukuVertikal: ImageView = itemView.findViewById(R.id.imgBukuVertikal)
        val tvJudulVertikal: TextView = itemView.findViewById(R.id.tvJudulVertikal)
        val tvPenulisVertikal: TextView = itemView.findViewById(R.id.tvPenulisVertikal)

        fun bind(buku: BukuModel) {
            tvJudulVertikal.text = buku.judul
            tvPenulisVertikal.text = buku.penulis
            imgBukuVertikal.setImageResource(buku.cover)

            itemView.setOnClickListener { onItemClick(buku) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_buku_vertikal, parent, false)
        return BukuViewHolder(view)
    }

    override fun onBindViewHolder(holder: BukuViewHolder, position: Int) {
        holder.bind(listBuku[position])
    }

    override fun getItemCount(): Int = listBuku.size
}