package com.example.projek_arkan

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class BukuAdapter(context: Context, private val bukuList: List<BukuModel>) :
    ArrayAdapter<BukuModel>(context, 0, bukuList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_buku, parent, false)
        val currentBuku = getItem(position)

        val imgCover = view.findViewById<ImageView>(R.id.imgCover)
        val tvJudul = view.findViewById<TextView>(R.id.tvJudul)
        val tvPenulis = view.findViewById<TextView>(R.id.tvPenulis)
        val btnDetail = view.findViewById<Button>(R.id.btnDetail)

        currentBuku?.let {
            imgCover.setImageResource(it.cover)
            tvJudul.text = it.judul
            tvPenulis.text = it.penulis
        }

        // Perintah agar tombol DETAIL berfungsi memanggil halaman DetailBukuActivity
        btnDetail.setOnClickListener {
            val intent = Intent(context, DetailBukuActivity::class.java)
            context.startActivity(intent)
        }

        // Perintah agar kotakan kartu secara keseluruhan juga bisa di-klik
        view.setOnClickListener {
            val intent = Intent(context, DetailBukuActivity::class.java)
            context.startActivity(intent)
        }

        return view
    }
}