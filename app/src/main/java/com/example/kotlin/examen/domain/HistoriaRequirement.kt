package com.example.kotlin.examen.domain

import com.example.kotlin.examen.data.network.model.HistoriaObject
import com.example.kotlin.examen.data.repository.HistoriaRepository

/**
 * Clase que representa el requisito de obtener los datos de historia.
 */
class HistoriaRequirement {
    private val repositorio = HistoriaRepository()

    /**
     * Obtiene los datos de historia utilizando el repositorio.
     * El resultado de la operación se devuelve mediante un callback.
     *
     * @param callback Función de callback que recibe los datos de historia o una excepción en caso de error.
     */
    fun obtenerDatosHistoria(callback: (resultado: HistoriaObject?, error: Exception?) -> Unit) {
        repositorio.obtenerDatosHistoria(callback)
    }
}
