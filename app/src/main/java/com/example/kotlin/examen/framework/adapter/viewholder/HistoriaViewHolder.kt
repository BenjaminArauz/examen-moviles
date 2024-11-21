package com.example.kotlin.examen.framework.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examen.data.network.model.HistoriaWrapper
import com.example.kotlin.examen.databinding.ItemHistoriaBinding

/**
 * Clase que se encarga de adaptar los datos de la lista de historias a la vista
 */
class HistoriaViewHolder(
    private val binding: ItemHistoriaBinding,
) : RecyclerView.ViewHolder(binding.root) {
    /**
     * Asigna los datos de la historia a la vista
     *
     * @param historia Datos de la historia a mostrar
     */
    fun bind(historia: HistoriaWrapper) {
        binding.TVDescripcion.text = historia.estimatedData.descripcion
        binding.TVCategoria1.text = historia.estimatedData.categoria1
        binding.TVCategoria2.text = historia.estimatedData.categoria2
    }
}
