package com.olympia.mfa.view_pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.olympia.databinding.MfaFragmentMainEntertainmentBinding
import com.olympia.mfa.data.VPAdapter
import com.olympia.mfa.view_pager.chat.Chat

class MainEntertainment : Fragment() {
    private lateinit var binding: MfaFragmentMainEntertainmentBinding
    private val arrayOfFragments = arrayOf(Chat.newInstance(), CristalBall.newInstance(), LottieTest.newInstance())
    private val arrayOfTitlesForFragments = arrayOf("Chat", "Cristal Ball", "Test Animations")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MfaFragmentMainEntertainmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = VPAdapter(activity as AppCompatActivity, arrayOfFragments)
        val controller = findNavController()
        binding.ContentVP.adapter = adapter
        TabLayoutMediator(binding.TabFragment, binding.ContentVP){ tab, pos ->
            tab.text = arrayOfTitlesForFragments[pos]
        }.attach()
        binding.GoBackOnME.setOnClickListener { controller.navigateUp() }
    }
}