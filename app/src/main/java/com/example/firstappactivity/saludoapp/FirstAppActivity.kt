package com.example.firstappactivity.saludoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.firstappactivity.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
       //todo= asi se declara un boton o editText, etc...
        val btnStart = findViewById<Button>(R.id.btnStart)
        val etName = findViewById<EditText>(R.id.etName)

        btnStart.setOnClickListener {
            val name = etName.text.toString()
            if (name.isNotEmpty()){
                //todo= Asi se declara un intent para pasar a otra pantalla
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }
        }
        //todo= Asi de declara cuando clickeamos un boton...
        etName.setOnClickListener {  }
    }
}