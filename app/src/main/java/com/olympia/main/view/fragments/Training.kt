package com.olympia.main.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.olympia.R
import com.olympia.databinding.FragmentTrainingBinding
import com.olympia.main.view.description
import com.olympia.mfa.MainActivity2

class Training : Fragment() {
    private lateinit var binding: FragmentTrainingBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTrainingBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text.setOnClickListener {
            startActivity(Intent((activity as AppCompatActivity), MainActivity2::class.java))
        }
        Glide.with((activity as AppCompatActivity)).load(R.drawable.animation).into(binding.imageView)
    }
    companion object {
        @JvmStatic
        fun newInstance() = Training()
    }
}