package com.example.kotlin.examen.framework.views.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examen.data.network.model.HistoriaWrapper
import com.example.kotlin.examen.databinding.ActivityMainBinding
import com.example.kotlin.examen.framework.adapter.HistoriaAdapter
import com.example.kotlin.examen.framework.viewmodel.MainViewModel

/**
 * Clase que representa la actividad principal de la aplicación.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private val adapter: HistoriaAdapter = HistoriaAdapter()

    /**
     * Método que se ejecuta al crear la actividad.
     * @param savedInstanceState Estado de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inicializarBinding()
        inicializarComponents()
        inicializarListeners()
        inicializarObservers()
        viewModel.obtenerDatosHistoria()
    }

    /**
     * Método que inicializa el binding de la actividad.
     */
    private fun inicializarBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /**
     * Método que inicializa los componentes de la actividad.
     */
    private fun inicializarComponents() {
        recyclerView = binding.RVHistoria
    }

    /**
     * Método que inicializa los listeners de la actividad.
     */
    private fun inicializarListeners() {
        binding.llHistoriaCiudad.setOnClickListener {
            // TODO: Implementar
        }
    }

    /**
     * Método que inicializa los observers de la actividad.
     */
    private fun inicializarObservers() {
        // Observa los cambios en datosHistoria
        // Actualiza el RecyclerView si hay datos disponibles
        viewModel.datosHistoria.observe(this) { historiaObject ->
            if (historiaObject != null) {
                actualizarRecyclerView(historiaObject.datos)
            }
        }

        // Observa los cambios en error
        viewModel.error.observe(this) { error ->
            if (error != null) {
                error?.let {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    /**
     * Método que actualiza el RecyclerView con los datos de la lista.
     * @param datosLista Lista de datos a mostrar.
     */
    private fun actualizarRecyclerView(datosLista: ArrayList<HistoriaWrapper>) {
        recyclerView.setHasFixedSize(true)

        val linearLayoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false,
            )
        recyclerView.layoutManager = linearLayoutManager
        adapter.HistoriaAdapter(datosLista)
        recyclerView.adapter = adapter
    }
}
