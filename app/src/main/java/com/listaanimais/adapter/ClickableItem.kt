package com.listaanimais.adapter

import com.listaanimais.model.Animals

interface ClickableItem {

    fun onDelete(animal: Animals)

}