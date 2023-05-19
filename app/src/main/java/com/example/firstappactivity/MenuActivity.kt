package com.example.firstappactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.firstappactivity.IMC.IMCActivity
import com.example.firstappactivity.saludoapp.FirstAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        val btnIMC = findViewById<Button>(R.id.btnIMC)

        btnSaludar.setOnClickListener { navigateToSaludar() }
        btnIMC.setOnClickListener { navigateToIMC() }
    }
    private fun navigateToSaludar(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToIMC(){
        val intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }
}