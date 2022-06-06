package com.example.arteycultura.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arteycultura.data.ProducPaint
import com.example.arteycultura.R

class ProducPaintAdapter(val listProduct:List<ProducPaint>) : RecyclerView.Adapter<ProductPaintHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductPaintHolder {
        val layoutInfleter = LayoutInflater.from(parent.context)
        return ProductPaintHolder(layoutInfleter.inflate(R.layout.card_list_product,parent, false))
    }

    override fun onBindViewHolder(holder: ProductPaintHolder, position: Int) {
        val item = listProduct[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = listProduct.size
}