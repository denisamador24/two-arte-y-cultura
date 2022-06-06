package com.example.arteycultura.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arteycultura.R

class ListTipoAdapter(val list: List<String>): RecyclerView.Adapter<ListTipoAdapter.ListTipoHolder>() {



    class ListTipoHolder(val view: View): RecyclerView.ViewHolder(view){

        val viewTipo = view.findViewById<TextView>(R.id.textItemTipo)

        fun render(tipo: String){
            viewTipo.text = tipo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListTipoHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListTipoHolder(layoutInflater.inflate(R.layout.item_tipos_folklore, parent, false))
    }

    override fun onBindViewHolder(holder: ListTipoHolder, position: Int) {
        holder.render(list[position])
    }

    override fun getItemCount(): Int = list.size
}