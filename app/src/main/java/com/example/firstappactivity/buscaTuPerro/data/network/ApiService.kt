package com.example.firstappactivity.buscaTuPerro.data.network

import com.example.firstappactivity.buscaTuPerro.data.model.BreedImgResponse
import com.example.firstappactivity.buscaTuPerro.data.model.DogsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getDogsByBreeds(@Url url:String): Response<DogsResponse>
    @GET
    suspend fun getBreedImg(@Url breed:String):Response<BreedImgResponse>
}