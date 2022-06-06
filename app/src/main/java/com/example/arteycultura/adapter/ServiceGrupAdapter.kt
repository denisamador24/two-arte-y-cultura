package com.example.arteycultura.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arteycultura.R
import com.example.arteycultura.data.ServiceGrup

class ServiceGrupAdapter(val serviceList: List<ServiceGrup>): RecyclerView.Adapter<ServiceGrupHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceGrupHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
       return ServiceGrupHolder(layoutInflater.inflate(R.layout.card_list_grup, parent, false))
    }

    override fun onBindViewHolder(holder: ServiceGrupHolder, position: Int) {
        val item = serviceList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = serviceList.size
}