package com.listaanimais

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.listaanimais.adapter.AdapterListAnimals
import com.listaanimais.model.AnimalEnum
import com.listaanimais.model.Animals

class MainActivity : AppCompatActivity() {

    private lateinit var animalRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfAnimals = listOf<Animals>(
            Animals("Cachorro","Branco", AnimalEnum.CACHORROBRANCO),
            Animals("Cachorro","Marrom", AnimalEnum.CACHORROMARROM),
            Animals("Gato","Preto", AnimalEnum.GATOPRETO),
            Animals("Gato","Branco",AnimalEnum.GATOBRANCO),
            Animals("Vaca","Pintada",AnimalEnum.VACAPINTADA),
            Animals("Vaca","Preta",AnimalEnum.VACAPRETA),

        )



        animalRecyclerView = findViewById(R.id.animalRecyclerView)
        animalRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        animalRecyclerView.adapter = AdapterListAnimals(listOfAnimals)
    }
}

