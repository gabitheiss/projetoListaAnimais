package com.listaanimais.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.listaanimais.MainActivity
import com.listaanimais.R
import com.listaanimais.model.Animals

class AdapterListAnimals(
    var listOfAnimals: MutableList<Animals>,
    var onClickableItem: MainActivity
) : RecyclerView.Adapter<ItemAnimalsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAnimalsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.itens_animais, parent, false)
        return ItemAnimalsViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ItemAnimalsViewHolder, position: Int) {
        listOfAnimals[position].apply {
            viewHolder.bind(this)

            viewHolder.itemView.findViewById<Button>(R.id.buttonDelete).let{
            it.setOnClickListener {
                onClickableItem.onDelete(this)
              }
             }
            }
        }



    override fun getItemCount(): Int {
        return listOfAnimals.size
    }

    fun removeAt(animals: Animals){
        listOfAnimals.remove(animals)
        notifyDataSetChanged()

    } fun add(animals: Animals){
        listOfAnimals.add(animals)
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