package com.example.arteycultura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arteycultura.component.InfoFragment
import com.example.arteycultura.data.ListProfiles
import de.hdodenhof.circleimageview.CircleImageView

class InfoProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_profile)

        val foto = findViewById<CircleImageView>(R.id.activityInfoProfile_ImageView)
        val name = findViewById<TextView>(R.id.activityInfoProfile_TextName)
        val price = findViewById<TextView>(R.id.activityInfoProfile_textPrice)
        val recyclerViewProduc = findViewById<RecyclerView>(R.id.activityInfoProfile_RecyclerViewProduc)
        val nameProduc = findViewById<TextView>(R.id.activityInfoProfile_cardListProduc_name)
        val imageProduct = findViewById<ImageView>(R.id.activityInfoProfile_cardListProduct_Img)
        val description = findViewById<TextView>(R.id.activityInfoProfile_cardLisProduct_description)
        val infoButton = findViewById<ImageView>(R.id.activityInfoProfile_imageViewInfo)

        infoButton.setOnClickListener {
            val dialog = InfoFragment("Dirección", "88888888")
            dialog.show(supportFragmentManager, "Info")
        }

        val propietario = intent.getIntExtra("propietario", 0)
        val nameProduct = intent.getStringExtra("nameProduct")
        val fotoProduct = intent.getIntExtra("fotoUri", R.drawable.nica_artesano)
        val descriptionProduc = intent.getStringExtra("descriptionProduct")

        val profiles = ListProfiles.listProfile[propietario]

        foto.setImageResource(profiles.UriFoto)
        name.text = profiles.name
        price.text = profiles.rangePrice
        nameProduc.text = nameProduct
        imageProduct.setImageResource(fotoProduct)
        description.text = descriptionProduc

    }
}