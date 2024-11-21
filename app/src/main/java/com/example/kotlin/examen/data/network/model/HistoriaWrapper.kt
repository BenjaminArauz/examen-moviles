package com.example.kotlin.examen.data.network.model

import com.google.gson.annotations.SerializedName

/**
 * Modelo de datos que representa la información básica de una historia en la aplicación Examen.
 *
 * @property estimatedData Datos estimados de la historia.
 */
data class HistoriaWrapper(
    @SerializedName("estimatedData") val estimatedData: HistoriaBase,
)
