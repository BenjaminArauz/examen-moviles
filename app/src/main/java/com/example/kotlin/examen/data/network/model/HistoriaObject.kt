package com.example.kotlin.examen.data.network.model

import com.google.gson.annotations.SerializedName

/**
 * Modelo de datos que representa la información de un objeto de historias en la aplicación Examen.
 *
 * @property codigo Código de respuesta de la petición.
 * @property datos Lista de objetos de historias.
 */
data class HistoriaObject(
    @SerializedName("code") val codigo: Int,
    @SerializedName("data") val datos: ArrayList<HistoriaWrapper>,
)
