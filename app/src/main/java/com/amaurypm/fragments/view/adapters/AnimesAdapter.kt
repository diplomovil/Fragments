package com.amaurypm.fragments.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.amaurypm.fragments.databinding.AnimesElementBinding
import com.amaurypm.fragments.model.Anime

/**
 * Creado por Amaury Perea Matsumura el 15/10/22
 */
class AnimesAdapter(private val context: Context, val datos: ArrayList<Anime>): BaseAdapter() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(position: Int): Any {
        return datos[position]
    }

    override fun getItemId(position: Int): Long {
        return datos[position].id
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding = AnimesElementBinding.inflate(layoutInflater)

        with(binding){
            tvTitulo.text = datos[position].titulo
            tvTipo.text = datos[position].tipo
            tvFecha.text = datos[position].fecha
        }

        return binding.root
    }
}