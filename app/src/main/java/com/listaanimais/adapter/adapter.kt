package com.listaanimais.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.listaanimais.R
import com.listaanimais.model.animals

class AdapterListAnimals (
    var listOfAnimals: List<animals>) : RecyclerView.Adapter<ItemAnimalsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAnimalsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itens_animais,parent,false)
        return ItemAnimalsViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ItemAnimalsViewHolder, position: Int) {
        listOfAnimals[position].apply {
            viewHolder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listOfAnimals.size
    }


    }


class ItemAnimalsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(car: animals) {

        itemView.findViewById<TextView>(R.id.TextViewMarca).apply {
            text = car.nomeAnimal
        }
        itemView.findViewById<TextView>(R.id.TextViewModelo).apply {
            text = car.corAnimal
        }

    }
}