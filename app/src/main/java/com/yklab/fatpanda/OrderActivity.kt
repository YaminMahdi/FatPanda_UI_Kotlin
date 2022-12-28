package com.yklab.fatpanda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yklab.fatpanda.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.extras

        binding.foodImageView.setImageResource(data?.getInt("pic")!!)
        binding.nm.text=data.getString("nm")
        binding.rate.text=data.getString("rate")
        binding.time.text=data.getString("time")
        binding.price.text=data.getString("price")

        var quantity=binding.quantity.text.toString().toInt()
        var price= data.getString("price")?.substring(1).toString().toInt()
        binding.btnMinus.setOnClickListener{
            if(quantity>1)
                quantity--
            binding.quantity.text=quantity.toString()
            binding.price.text="৳"+price*quantity

        }
        binding.btnPlus.setOnClickListener{
            quantity++
            binding.quantity.text=quantity.toString()
            binding.price.text="৳"+price*quantity
        }
        binding.btnBack.setOnClickListener{
            super.onBackPressed()
        }
        binding.btnCart.setOnClickListener{
            Toast.makeText(this,"Added to cart",Toast.LENGTH_SHORT).show()
        }

    }
}