package com.example.firstappactivity.superHeroApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.Px
import com.example.firstappactivity.R
import com.example.firstappactivity.databinding.ActivityDetailSuperHeroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.math.roundToInt

class DetailSuperHeroActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }
    private lateinit var binding: ActivityDetailSuperHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperHeroInformation(id)
    }


    private fun getSuperHeroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail = getRetrofit().create(ApiService::class.java).getSuperHeroDetail(id)

            if (superheroDetail.body() != null){
                runOnUiThread{createUi(superheroDetail.body()!!)}
                superheroDetail.body()
            }
        }

    }

    private fun createUi(superhero: SuperHeroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperHero)
        binding.tvSuperHeroName.text = superhero.name
        prepareStats(superhero.powerstats)

    }
    private fun prepareStats(powerStats: PowerStatsResponse){
        updateHeight(binding.combat, powerStats.combat)
        updateHeight(binding.intelligence, powerStats.intelligence)
        updateHeight(binding.strength, powerStats.strength)
        updateHeight(binding.speed, powerStats.speed)
        updateHeight(binding.power, powerStats.power)
        updateHeight(binding.durability, powerStats.durability)

    }
    private fun updateHeight(view: View, stat:String){
        val params = view.layoutParams
        params.height = pxToDp(stat.toFloat())
        view.layoutParams = params
    }
    private fun pxToDp(px:Float):Int {
       return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()

    }

    private fun getRetrofit(): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}
