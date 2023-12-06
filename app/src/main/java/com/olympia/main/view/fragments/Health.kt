package com.olympia.main.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.olympia.R
import com.olympia.databinding.FragmentHealthBinding
import com.olympia.main.view.description
import com.olympia.main.view.for_recycler_view.RVItem
import com.olympia.main.view.for_recycler_view.adapters.HealthRVAdapter

class Health : Fragment(), HealthRVAdapter.IListener {
    private lateinit var binding: FragmentHealthBinding
    private val infAdapter = HealthRVAdapter(this)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHealthBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myHealthItems = arrayOf(
            RVItem(R.drawable.blood_analysis, getString(R.string.blood_analysis), resources.getStringArray(R.array.forMyHealth)[0]),
            RVItem(R.drawable.weight_analysis, getString(R.string.weight_analysis), resources.getStringArray(R.array.forMyHealth)[1]),
            RVItem(R.drawable.plan, getString(R.string.recommended_meal_plan), resources.getStringArray(R.array.forMyHealth)[2]),
            RVItem(R.drawable.vitamins, getString(R.string.vitamins), resources.getStringArray(R.array.forMyHealth)[3])
        )
        for (i in myHealthItems) {
            infAdapter.addInf(i)
        }
        binding.RVOnMyHealth.layoutManager = GridLayoutManager(activity as AppCompatActivity, 1)
        binding.RVOnMyHealth.adapter = infAdapter
    }
    companion object {
        @JvmStatic
        fun newInstance() = Health()
    }
    override fun onClick(healthItem: RVItem) {
        description(healthItem)
    }
}