package com.example.kotlin.examen.framework.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examen.data.network.model.HistoriaWrapper
import com.example.kotlin.examen.databinding.ItemHistoriaBinding
import com.example.kotlin.examen.framework.adapter.viewholder.HistoriaViewHolder

/**
 * Clase que se encarga de adaptar los datos de la lista de historias a la vista
 */
class HistoriaAdapter : RecyclerView.Adapter<HistoriaViewHolder>() {
    var data: ArrayList<HistoriaWrapper> = ArrayList()

    fun HistoriaAdapter(basicData: ArrayList<HistoriaWrapper>) {
        this.data = basicData
    }

    /**
     * Método que se encarga de crear el ViewHolder
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): HistoriaViewHolder {
        val binding = ItemHistoriaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoriaViewHolder(binding)
    }

    /**
     * Método que se encarga de bindear los datos a la vista
     */
    override fun onBindViewHolder(
        holder: HistoriaViewHolder,
        position: Int,
    ) {
        val item = data[position]
        holder.bind(item)
    }

    /**
     * Método que se encarga de obtener el tamaño de la lista de historias
     */
    override fun getItemCount(): Int = data.size
}
