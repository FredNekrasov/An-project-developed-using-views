package com.olympia.main.view.for_recycler_view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olympia.R
import com.olympia.databinding.HealthItemBinding
import com.olympia.main.view.for_recycler_view.RVItem

class HealthRVAdapter(private val listener: IListener): RecyclerView.Adapter<HealthRVAdapter.MyHealthHolder> () {
    private val infArray = ArrayList<RVItem>()
    class MyHealthHolder(item: View): RecyclerView.ViewHolder(item) {
        private val itemBinding = HealthItemBinding.bind(item)
        fun bind(healthItem: RVItem, listener: IListener) = with(itemBinding){
            ImageOfItem.setImageResource(healthItem.imageId)
            TitleOfItem.text = healthItem.title
            MyHealthItemCard.setOnClickListener {
                listener.onClick(healthItem)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHealthHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.health_item, parent, false)
        return MyHealthHolder(view)
    }
    override fun getItemCount(): Int {
        return infArray.size
    }
    override fun onBindViewHolder(holder: MyHealthHolder, position: Int) {
        holder.bind(infArray[position], listener)
    }
    interface IListener{
        fun onClick(healthItem: RVItem)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun addInf(healthItem: RVItem){
        infArray.add(healthItem)
        notifyDataSetChanged()
    }
}