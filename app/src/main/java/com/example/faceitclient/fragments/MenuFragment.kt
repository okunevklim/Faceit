package com.example.faceitclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.faceitclient.R
import com.example.faceitclient.databinding.FragmentMenuBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private val tabIcons = intArrayOf(R.drawable.ic_friends)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager2.offscreenPageLimit = 1
        binding.viewPager2.isUserInputEnabled = false
        val sections = arrayOf(
            getString(R.string.section_friends)
        )
        TabLayoutMediator(
            binding.tabLayout, binding.viewPager2, true, false
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = sections[position]
        }.attach()
        setupTabIcons()
    }

    private fun setupTabIcons() {
        binding.tabLayout.getTabAt(0)?.setIcon(tabIcons[0])
    }
}