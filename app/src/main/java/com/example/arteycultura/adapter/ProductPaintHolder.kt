package com.example.arteycultura.adapter

import android.content.Intent
import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.arteycultura.InfoProfileActivity
import com.example.arteycultura.ProducPaint
import com.example.arteycultura.R

class ProductPaintHolder(val view : View): RecyclerView.ViewHolder(view) {

    val nameProduct = view.findViewById<TextView>(R.id.cardListProduc_name)
    val descriptionProduc = view.findViewById<TextView>(R.id.cardLisProduct_description)
    val imgProduct = view.findViewById<ImageView>(R.id.cardListProduct_Img)
    val cardView = view.findViewById<CardView>(R.id.cardViewListProduc)

    fun render (producPaintModel: ProducPaint){
        nameProduct.text = producPaintModel.name
        descriptionProduc.text = producPaintModel.description

        cardView.setOnClickListener {
            val intent = Intent(view.context, InfoProfileActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}