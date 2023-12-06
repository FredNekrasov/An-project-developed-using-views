package com.olympia.mfa.view_pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.olympia.R
import com.olympia.databinding.MfaFragmentCristalBallBinding
import com.olympia.main.view.getItemFromArray

class CristalBall : Fragment() {
    private lateinit var binding: MfaFragmentCristalBallBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MfaFragmentCristalBallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.divinationText.setOnClickListener { binding.divinationText.text = getItemFromArray(R.array.forCB) }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CristalBall()
    }
}