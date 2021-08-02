package com.listaanimais

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.listaanimais.adapter.AdapterListAnimals
import com.listaanimais.model.animals

class MainActivity : AppCompatActivity() {

    private lateinit var animalRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfAnimals = listOf<animals>(
            animals("Cachorro","Branco"),
            animals("Cachorro","Marrom"),
            animals("Gato","Preto"),
            animals("Gato","Branco"),
            animals("Vaca","Pintada"),
            animals("Boi","Branco"),
            animals("Pato","Cinza"),
        )



        animalRecyclerView = findViewById(R.id.animalRecyclerView)
        animalRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        animalRecyclerView.adapter = AdapterListAnimals(listOfAnimals)
    }
}

