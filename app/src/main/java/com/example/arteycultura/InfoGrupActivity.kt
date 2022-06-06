package com.example.arteycultura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class InfoGrupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_grup)

        val image = findViewById<ImageView>(R.id.activityInfoGrup_imageView)
        val name = findViewById<TextView>(R.id.activityInfoGrup_textViewName)
        val comarca = findViewById<TextView>(R.id.activityInfoGrup_comarca)
        val listTipo = findViewById<ListView>(R.id.activityInfoGrup_ListTipos)
        val listFoto = findViewById<RecyclerView>(R.id.activityInfoGrup_listFotos)
        val carMusic = findViewById<CardView>(R.id.cardViewMusic)


        val UriFoto = intent.getIntExtra("foto", R.drawable.nica_artesano)
        val textName = intent.getStringExtra("name")
        val textComarca = intent.getStringExtra("comarca")
        val grup = intent.getStringExtra("grup")

        carMusic.visibility = View.GONE

        image.setImageResource(UriFoto)
        name.text = textName
        comarca.text = textComarca

    }
}