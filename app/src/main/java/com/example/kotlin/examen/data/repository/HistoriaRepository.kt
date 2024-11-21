package com.example.kotlin.examen.data.repository

import android.util.Log
import com.example.kotlin.examen.data.network.NetworkModuleDI
import com.example.kotlin.examen.data.network.model.HistoriaObject
import com.google.gson.Gson
import com.parse.ParseException

/**
 * Clase que se encarga de obtener la información de la historia.
 */
class HistoriaRepository {
    private val gson = Gson()

    fun obtenerDatosHistoria(callback: (resultado: HistoriaObject?, error: Exception?) -> Unit) {
        val parametros = hashMapOf<String, Any>()
        NetworkModuleDI.callCloudFunction<HashMap<String, Any>>("hello?page=1", parametros) { resultado, error ->
            if (error == null && resultado is HashMap<*, *>) {
                try {
                    Log.d("HistoriaRepository", "Resultado de la función: $resultado")
                    // Convierte el resultado a un objeto JSON.
                    val json = gson.toJson(resultado)
                    Log.d("HistoriaRepository", "JSON: $json")
                    // Deserializa el JSON en un objeto HistoriaObject.
                    val historiaObject = gson.fromJson(json, HistoriaObject::class.java)
                    callback(historiaObject, null)
                } catch (e: Exception) {
                    callback(null, Exception("Error al obtener la información"))
                }
            } else {
                // Maneja las excepciones de ParseException.
                if (error is ParseException && error.code == 1) {
                    callback(null, Exception("Error de conexión con la base de datos"))
                } else if (error is ParseException && error.code == 100) {
                    callback(null, Exception("Error de conexión"))
                } else {
                    callback(null, error)
                }
            }
        }
    }
}
