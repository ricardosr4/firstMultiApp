package com.example.firstappactivity.IMC

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.firstappactivity.IMC.IMCActivity.Companion.IMC_KEY
import com.example.firstappactivity.R

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnRecalcular: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponent()
        initUi(result)
        initListener()
    }

    private fun initListener() {
        btnRecalcular.setOnClickListener { onBackPressed() }

    }

    private fun initUi(result: Double) {
        tvIMC.text = result.toString()
        when(result){
            in 0.00..18.50 ->{  // bajo peso

                tvResult.text= getString(R.string.title_bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_bajo_peso)
            }
            in 18.51..24.99 -> { // peso normal

                tvResult.text = getString(R.string.title_normal)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_normal))
                tvDescription.text = getString(R.string.description_normal)
            }
            in 25.00..29.99 -> { // sobre peso

                tvResult.text = getString(R.string.title_sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_sodbrepeso))
                tvDescription.text = getString(R.string.description_sobrepeso)
            }
            in 30.00..99.99 -> { // Obesidad

                tvResult.text = getString(R.string.title_obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_obesidad))
                tvDescription.text = getString(R.string.description_obesidad)
            }
            else  -> { // error
                tvIMC.text = "error"
                tvResult.text = "error"
                tvDescription.text = "error"
            }

        }

    }

    private fun initComponent() {
        tvIMC = findViewById(R.id.tvIMC)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalcular = findViewById(R.id.btnRecalcular)
    }
}