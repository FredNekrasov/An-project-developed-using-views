package com.olympia.main.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olympia.R
import com.olympia.databinding.FragmentHomeBinding
import com.olympia.main.view.Info
import com.olympia.main.view.description
import com.olympia.main.view.for_recycler_view.RVItem
import com.olympia.main.view.for_recycler_view.adapters.HomeRVAdapter

class Home : Fragment(), HomeRVAdapter.IListener {
    private lateinit var binding: FragmentHomeBinding
    private val infAdapter = HomeRVAdapter(this)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeCommunityItems = arrayOf(
            RVItem(R.drawable.community_article1, getString(R.string.community_article1), Info.homeDescription0),
            RVItem(R.drawable.community_article2, getString(R.string.community_article2), Info.homeDescription1),
            RVItem(R.drawable.community_article3, getString(R.string.community_article3), Info.homeDescription2)
        )
        for (i in homeCommunityItems) {
            infAdapter.addInf(i)
        }
        binding.RVOnHome.layoutManager = GridLayoutManager(activity as AppCompatActivity, 1, RecyclerView.HORIZONTAL, false)
        binding.RVOnHome.adapter = infAdapter
    }
    companion object {
        @JvmStatic
        fun newInstance() = Home()
    }
    override fun onClick(homeItem: RVItem) {
        description(homeItem)
    }
}