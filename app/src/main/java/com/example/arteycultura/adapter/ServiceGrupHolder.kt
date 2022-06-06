package com.example.arteycultura.adapter

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.arteycultura.InfoGrupActivity
import com.example.arteycultura.R
import com.example.arteycultura.data.ListFotos
import com.example.arteycultura.data.ServiceGrup
import de.hdodenhof.circleimageview.CircleImageView

class ServiceGrupHolder(val view: View): RecyclerView.ViewHolder(view) {

    val name = view.findViewById<TextView>(R.id.cardListGrup_name)
    val comarca = view.findViewById<TextView>(R.id.cardListGrup_comarca)
    val img  = view.findViewById<CircleImageView>(R.id.cardListGrup_imageView_profile)
    val card = view.findViewById<CardView>(R.id.cardListGrup)

    fun render (serviceListGrup: ServiceGrup) {
        name.text = serviceListGrup.name
        comarca.text = serviceListGrup.comarca
        img.setImageResource(serviceListGrup.foto)

        card.setOnClickListener {
            val intent = Intent(view.context, InfoGrupActivity::class.java)
            intent.putExtra("foto", serviceListGrup.foto)
            intent.putExtra("name", serviceListGrup.name)
            intent.putExtra("comarca", serviceListGrup.comarca)
            intent.putExtra("address", serviceListGrup.address)
            intent.putExtra("phoneNumber", serviceListGrup.phoneNumber)
            intent.putExtra("tipo", serviceListGrup.tipos)
            intent.putExtra("grup", "")
            view.context.startActivity(intent)
        }
    }
}