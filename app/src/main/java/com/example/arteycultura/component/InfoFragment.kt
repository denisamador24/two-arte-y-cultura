package com.example.arteycultura.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.arteycultura.R

class InfoFragment(val address: String?, val phoneNumber: String?): DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.card_extra_info, container, false)

        val addressView = view.findViewById<TextView>(R.id.cardInfo_addressText)
        val phoneNumberView = view.findViewById<TextView>(R.id.cardInfo_phoneNumberText)
        val buttonDismiss = view.findViewById<Button>(R.id.cardInfo_buttonDismiss)

        buttonDismiss.setOnClickListener {
            dismiss()
        }

        addressView.text = address
        phoneNumberView.text = phoneNumber

        return view
    }

}