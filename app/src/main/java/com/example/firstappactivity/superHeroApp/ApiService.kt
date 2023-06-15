package com.example.firstappactivity.superHeroApp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/2214041355447642/search/{name}")
    suspend fun getSuperHeroes(@Path("name") superHeroName: String): Response<SuperHeroDataResponse>

    @GET("/api/2214041355447642/{id}")
    suspend fun getSuperHeroDetail(@Path("id") supeheroId:String): Response<SuperHeroDetailResponse>

}