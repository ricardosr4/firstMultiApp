package com.example.firstappactivity.buscaTuPerro.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.firstappactivity.databinding.ItemDogBinding
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener

class DogViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemDogBinding.bind(view)

    fun bind(message:String, clickListener: (String,Int) -> Unit){
        binding.tvDogs.text = message

        binding.tvDogs.setOnClickListener { clickListener(message, binding.tvDogs.id)
        binding.cardbreed.setOnClickListener { clickListener(message, binding.cardbreed.id) }}
    }

}