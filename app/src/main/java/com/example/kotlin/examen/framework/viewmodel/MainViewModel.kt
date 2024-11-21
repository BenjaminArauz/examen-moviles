package com.example.kotlin.examen.framework.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin.examen.data.network.model.HistoriaObject
import com.example.kotlin.examen.domain.HistoriaRequirement

/**
 * ViewModel para la pantalla principal de la aplicación.
 */
class MainViewModel : ViewModel() {
    private val _datosHistoria = MutableLiveData<HistoriaObject?>()
    val datosHistoria: LiveData<HistoriaObject?> get() = _datosHistoria

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    private val historiaRequirement = HistoriaRequirement()

    /**
     * Obtiene los datos de historia.
     */
    fun obtenerDatosHistoria() {
        historiaRequirement.obtenerDatosHistoria { resultado, error ->
            if (resultado != null) {
                // Actualiza los valores de LiveData
                _datosHistoria.postValue(resultado)
            } else {
                _error.postValue(error?.message)
            }
        }
    }
}
