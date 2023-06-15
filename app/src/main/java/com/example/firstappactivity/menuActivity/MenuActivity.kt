package com.example.firstappactivity.menuActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.firstappactivity.IMC.IMCActivity
import com.example.firstappactivity.R
import com.example.firstappactivity.buscaTuPerro.ui.activity.ApiDogActivity
import com.example.firstappactivity.saludoapp.FirstAppActivity
import com.example.firstappactivity.superHeroApp.SuperHeroListActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        val btnIMC = findViewById<Button>(R.id.btnIMC)
        val btnSuperHero = findViewById<Button>(R.id.btnSuperHero)
        val btnApiDog = findViewById<Button>(R.id.btnApiDog)

        btnSaludar.setOnClickListener { navigateToSaludar() }
        btnIMC.setOnClickListener { navigateToIMC() }
        btnSuperHero.setOnClickListener { navigateToSuperHero() }
        btnApiDog.setOnClickListener { navigateToApiDog() }

    }
    private fun navigateToSaludar(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToIMC(){
        val intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToSuperHero(){
        val intent = Intent (this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToApiDog(){
        val intent = Intent (this, ApiDogActivity::class.java)
        startActivity(intent)
    }
}