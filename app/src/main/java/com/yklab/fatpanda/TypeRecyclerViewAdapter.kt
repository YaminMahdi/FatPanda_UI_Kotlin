package com.yklab.fatpanda


import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yklab.fatpanda.databinding.FoodTypeBinding

public data class FoodType(val nm: String, val emoji: String)

class TypeRecyclerViewAdapter(private val foodList: List<FoodType>) :
    RecyclerView.Adapter<TypeRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(private val binding: FoodTypeBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bindView(list: List<FoodType>, position: Int) {
            binding.nm.text = list[position].nm
            binding.emoji.text = list[position].emoji
            if(position==0)
                binding.cardViewBg.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#FFC01F"))
        }

        init {
            // Define click listener for the ViewHolder's View.
            binding.root.setOnClickListener {
                binding.cardViewBg.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#FFC01F"))
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        FoodTypeBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup, false
        )
    )

    override fun getItemCount() = foodList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(foodList, position)
    }
}