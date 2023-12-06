package com.olympia.mfa.data

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class VPAdapter(fa: FragmentActivity, private val array: Array<Fragment>): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = array.size
    override fun createFragment(position: Int): Fragment = array[position]
}