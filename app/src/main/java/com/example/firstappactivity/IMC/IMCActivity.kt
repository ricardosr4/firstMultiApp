package com.example.firstappactivity.IMC

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.firstappactivity.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class IMCActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentPeso: Int = 50
    private var currentEdad: Int = 18
    private var currentAltura: Int = 120


    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvAltura: TextView
    private lateinit var rangeSliderAltura: RangeSlider
    private lateinit var btnMenorPeso: FloatingActionButton
    private lateinit var btnMayorPeso: FloatingActionButton
    private lateinit var tvPeso: TextView
    private lateinit var btnMenorEdad: FloatingActionButton
    private lateinit var btnMayorEdad: FloatingActionButton
    private lateinit var tvEdad: TextView
    private lateinit var btnCalcular: Button

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcactivity)

        initComponent()
        initListener()
        initUi()

    }

    private fun initUi() {
        setGenderColor()
        setPeso()
        setEdad()
    }

    private fun initComponent() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvAltura = findViewById(R.id.tvAltura)
        rangeSliderAltura = findViewById(R.id.rangeSliderAltura)
        btnMenorPeso = findViewById(R.id.btnMenorPeso)
        btnMayorPeso = findViewById(R.id.btnMayorPeso)
        tvPeso = findViewById(R.id.tvPeso)
        btnMenorEdad = findViewById(R.id.btnMenorEdad)
        btnMayorEdad = findViewById(R.id.btnMayorEdad)
        tvEdad = findViewById(R.id.tvEdad)
        btnCalcular = findViewById(R.id.btnCalcular)

    }

    private fun initListener() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

        //todo= Aqui se quita el decimal que esta sobrando
        rangeSliderAltura.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentAltura = df.format(value).toInt()
            tvAltura.text = "$currentAltura cm"
        }
        btnMenorPeso.setOnClickListener {
            currentPeso -= 1
            setPeso()
        }
        btnMayorPeso.setOnClickListener {
            currentPeso += 1
            setPeso()
        }
        btnMenorEdad.setOnClickListener {
            currentEdad -= 1
            setEdad()
        }
        btnMayorEdad.setOnClickListener {
            currentEdad += 1
            setEdad()
        }
        btnCalcular.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }

    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentPeso / (currentAltura.toDouble() / 100 * currentAltura.toDouble() / 100)
        return df.format(imc).toDouble()
    }

    private fun setPeso() {
        tvPeso.text = currentPeso.toString()
    }

    private fun setEdad() {
        tvEdad.text = currentEdad.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected

    }

    private fun setGenderColor() {

        viewMale.setCardBackgroundColor(getBackgraundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgraundColor(isFemaleSelected))
    }

    private fun getBackgraundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.pink
        } else {
            R.color.blue
        }

        return ContextCompat.getColor(this, colorReference)
    }
}