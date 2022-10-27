package edu.farmingdale.alrajab.bcs421

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

lateinit var names : EditText
lateinit var saving : Button
lateinit var reading : Button
lateinit var updating : Button
lateinit var txtnew : TextView

class Spreference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spreference)

        names = findViewById(R.id.flname)
        saving = findViewById(R.id.buttons)
        reading = findViewById(R.id.buttonw)
        updating = findViewById(R.id.buttonu)
        txtnew = findViewById(R.id.txtoutput)

        saving.setOnClickListener { saves() }
        reading.setOnClickListener { writes() }
        updating.setOnClickListener { updates() }

    }

    fun saves(){

        var sharedpref = getSharedPreferences("news", MODE_PRIVATE)
        var slu = sharedpref.edit()
        slu.apply(){putString("new_String", names.text.toString())}

        Toast.makeText(this,"Successfully saved", Toast.LENGTH_LONG).show()
    }

    fun writes(){

        var sharedpref2 = getSharedPreferences("news", Context.MODE_PRIVATE)
        var wlu = sharedpref2.getString("new_String", names.text.toString())
        txtnew.text = wlu

    }

    fun updates(){

        var sharedpref3 = getSharedPreferences("news", Context.MODE_PRIVATE)
        var ulu = sharedpref3.edit()
        ulu.apply(){putString("update_string", names.text.toString())}

        Toast.makeText(this,"Record updated", Toast.LENGTH_LONG).show()
    }
}