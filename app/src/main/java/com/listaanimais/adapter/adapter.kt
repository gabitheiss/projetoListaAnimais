package com.listaanimais.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.listaanimais.R
import com.listaanimais.model.Animals

class AdapterListAnimals(
    var listOfAnimals: MutableList<Animals>,
    var onClick: (Animals) -> Unit
) : RecyclerView.Adapter<ItemAnimalsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAnimalsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.itens_animais, parent, false)
        return ItemAnimalsViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ItemAnimalsViewHolder, position: Int) {
        listOfAnimals[position].apply {
            viewHolder.bind(this)
            viewHolder.itemView.setOnClickListener{
                onClick(this)
            }
        }
    }

    override fun getItemCount(): Int {
        return listOfAnimals.size
    }

    fun removeAt(animals: Animals){
        listOfAnimals.remove(animals)
        notifyDataSetChanged()
    }


}


class ItemAnimalsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(animals: Animals) {

        itemView.findViewById<TextView>(R.id.TextViewMarca).apply {
            text = animals.nomeAnimal
        }
        itemView.findViewById<TextView>(R.id.TextViewModelo).apply {
            text = animals.corAnimal
        }
        itemView.findViewById<ImageView>(R.id.animalAvatar).apply {
            Glide.with(context)
                .load(animals.imagem.url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(this)
        }

    }
}