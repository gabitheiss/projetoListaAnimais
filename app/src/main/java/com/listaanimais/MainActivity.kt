package com.listaanimais

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.listaanimais.adapter.AdapterListAnimals
import com.listaanimais.model.AnimalEnum
import com.listaanimais.model.Animals

class MainActivity : AppCompatActivity() {

    private lateinit var animalRecyclerView: RecyclerView
    private lateinit var adapter: AdapterListAnimals

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfAnimals = mutableListOf<Animals>(
            Animals("Cachorro","Branco", AnimalEnum.CACHORROBRANCO),
            Animals("Cachorro","Marrom", AnimalEnum.CACHORROMARROM),
            Animals("Gato","Preto", AnimalEnum.GATOPRETO),
            Animals("Gato","Branco",AnimalEnum.GATOBRANCO),
            Animals("Vaca","Pintada",AnimalEnum.VACAPINTADA),
            Animals("Vaca","Preta",AnimalEnum.VACAPRETA),

        )

        adapter = AdapterListAnimals(listOfAnimals) {
          onClick(it)
        }

        animalRecyclerView = findViewById(R.id.animalRecyclerView)
        animalRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        animalRecyclerView.adapter = adapter



    }

    fun onClick(animals : Animals){
        adapter.removeAt(animals)

    }
}

