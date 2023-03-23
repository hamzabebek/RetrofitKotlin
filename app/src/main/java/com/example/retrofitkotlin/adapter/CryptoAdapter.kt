package com.example.retrofitkotlin.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitkotlin.databinding.RecyclerRowBinding
import com.example.retrofitkotlin.model.CryptoModel
import java.util.*
import kotlin.collections.ArrayList

class CryptoAdapter (private var cryptoList : ArrayList<CryptoModel>, private val listener : Listener) : RecyclerView.Adapter<CryptoAdapter.CryptoHolder>(){

    interface Listener {
        fun onItemClick(cryptoModel: CryptoModel)
    }


    class CryptoHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cryptoModel: CryptoModel, listener: Listener) {
            itemView.setOnClickListener{
                listener.onItemClick(cryptoModel)
            }
            val rnd = Random()
            val currentColor: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            itemView.setBackgroundColor(currentColor)
            binding.nameText.text = cryptoModel.currency
            binding.priceText.text = cryptoModel.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoHolder {
    val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CryptoHolder(binding)
    }

    override fun getItemCount(): Int {
         return cryptoList.size
    }

    override fun onBindViewHolder(holder: CryptoHolder, position: Int) {
        holder.bind(cryptoList[position],listener)
    }
}