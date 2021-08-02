package com.listaanimais

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.listaanimais.model.Animals

class DetailAnimalsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_animals)

       val animal = intent.getSerializableExtra("parametro_animal") as? Animals


        animal?.let{ myAnimal ->
            findViewById<ImageView>(R.id.logoImageView).apply {
                Glide.with(context)
                    .load(myAnimal.imagem.url)
                    .into(this)

            }

            findViewById<TextView>(R.id.nomeTextView).apply {
                text = myAnimal.nomeAnimal
            }

            findViewById<TextView>(R.id.corTextView).apply {
                text = myAnimal.corAnimal
            }
        }







    }
}