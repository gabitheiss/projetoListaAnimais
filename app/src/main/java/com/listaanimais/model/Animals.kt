package com.listaanimais.model

import java.io.Serializable

data class Animals(
    val nomeAnimal: String,
    val corAnimal: String,
    val imagem: AnimalEnum
): Serializable
