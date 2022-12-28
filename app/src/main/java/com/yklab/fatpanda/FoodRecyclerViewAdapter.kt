package com.yklab.fatpanda

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.yklab.fatpanda.databinding.FoodItemBinding

public data class FoodItem(
    val pic: Int,
    val nm: String,
    val price: String,
    val time: String,
    val rate: String
)

class FoodRecyclerViewAdapter(private val foodList: List<FoodItem>) :
    RecyclerView.Adapter<FoodRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(private val binding: FoodItemBinding, private val contest: Context) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(list: List<FoodItem>, position: Int) {
            binding.pic.setImageResource(list[position].pic)
            binding.nm.text = list[position].nm
            binding.rate.text = list[position].rate
            binding.price.text = list[position].price
            binding.time.text = list[position].time
            var bundle = Bundle()
            bundle.putInt("pic",list[position].pic)
            bundle.putString("nm",list[position].nm)
            bundle.putString("rate",list[position].rate)
            bundle.putString("time",list[position].time)
            bundle.putString("price",list[position].price)

            binding.btnPlus.setOnClickListener {
                val intent=Intent(contest, OrderActivity::class.java)
                intent.putExtras(bundle)
                startActivity(contest,intent, bundle)
            }

        }

        init {
            // Define click listener for the ViewHolder's View.

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        FoodItemBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup, false
        ),
        viewGroup.context
    )

    override fun getItemCount() = foodList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(foodList, position)
    }
}