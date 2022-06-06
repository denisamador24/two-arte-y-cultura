package com.example.arteycultura.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.arteycultura.R
import com.example.arteycultura.data.ListFotos

class ListFotoAdapter(val listFoto: List<Int>): RecyclerView.Adapter<ListFotoAdapter.ListFotoHolder>() {

    class ListFotoHolder(val view: View): RecyclerView.ViewHolder(view){

        val card = view.findViewById<CardView>(R.id.cardListFoto)
        val image = view.findViewById<ImageView>(R.id.cardListFoto_image)

        fun render (foto: Int){
            image.setImageResource(foto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListFotoHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListFotoHolder(layoutInflater.inflate(R.layout.list_image, parent, false))
    }

    override fun onBindViewHolder(holder: ListFotoHolder, position: Int) {
        holder.render(listFoto[position])
    }

    override fun getItemCount(): Int = listFoto.size
}