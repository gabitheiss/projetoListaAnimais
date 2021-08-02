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


        //botão de voltar - setinha - adicionar override fun onSupportNavigateUp()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


       val animal = intent.getSerializableExtra("parametro_animal") as? Animals


        animal?.let{ myAnimal ->
            //adicionar titulo
            supportActionBar?.title = "${myAnimal.nomeAnimal} - ${myAnimal.corAnimal}"

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

    //para o botão voltar funcionar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}