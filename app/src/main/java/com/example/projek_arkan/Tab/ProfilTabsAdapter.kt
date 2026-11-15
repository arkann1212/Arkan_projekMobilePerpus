package com.example.projek_arkan

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.projek_arkan.Tab.RiwayatFragment
import com.example.projek_arkan.Tab.TersimpanFragment

class ProfilTabsAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> RiwayatFragment()
            1 -> TersimpanFragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}