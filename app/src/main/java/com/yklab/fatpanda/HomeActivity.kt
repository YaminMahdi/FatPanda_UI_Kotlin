package com.yklab.fatpanda

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.yklab.fatpanda.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodTypes = mutableListOf<FoodType>();
        foodTypes.add(FoodType("Burger","\uD83C\uDF54"))
        foodTypes.add(FoodType("Pizza","\uD83C\uDF55"))
        foodTypes.add(FoodType("Hotdog","\uD83C\uDF2D"))
        foodTypes.add(FoodType("Chicken","\uD83C\uDF57"))
        foodTypes.add(FoodType("Meet","\uD83E\uDD69"))

        binding.recFoodType.adapter = TypeRecyclerViewAdapter(foodTypes)




        val foodItems = mutableListOf<FoodItem>();
        foodItems.add(FoodItem(R.drawable.burger,"Beef Burger","৳120","20min","4.5"))
        foodItems.add(FoodItem(R.drawable.burger,"Egg Burger","৳90","12min","4.4"))
        foodItems.add(FoodItem(R.drawable.pizza,"Greek Pizza","৳720","18min","4.0"))
        foodItems.add(FoodItem(R.drawable.pizza,"BBQ Pizza","৳920","22min","4.8"))

        binding.recFood.adapter = FoodRecyclerViewAdapter(foodItems)



    }
}