package com.example.kotlin.examen.data.network.model

import com.google.gson.annotations.SerializedName

/*
* Modelo de datos que representa la información básica de una historia en la aplicación Examen.
 */
data class HistoriaBase(
    @SerializedName("description") val descripcion: String,
    @SerializedName("category1") val categoria1: String,
    @SerializedName("category2") val categoria2: String,
    @SerializedName("createdAt") val fechaCreacion: String,
    @SerializedName("lang") val lenguaje: String,
    @SerializedName("date") val fecha: String,
)
