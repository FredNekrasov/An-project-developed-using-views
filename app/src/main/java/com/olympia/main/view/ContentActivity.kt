package com.olympia.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.olympia.databinding.ActivityContentBinding
import com.olympia.main.view.for_recycler_view.RVItem

class ContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val item = intent.getSerializableExtra("Cat") as RVItem
        binding.ContentView.setImageResource(item.imageId)
        binding.TitleView.text = item.title
        binding.DescriptionText.text = item.description
        binding.BGoBackOnContent.setOnClickListener { finish() }
    }
}