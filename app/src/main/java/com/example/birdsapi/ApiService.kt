package com.example.birdsapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

//Image generator image service
private  val retrofitImage = Retrofit.Builder().baseUrl("https://api.ebird.org/v2/data/obs/KZ/recent")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val imageResponse = retrofitImage.create(ImageApiService::class.java)

interface ImageApiService{
    @Headers("X-eBirdApiToken: gi422aer30qs")
    @GET("/search/photos")
    suspend fun searchImage(
        @Query("query") word: String): ApiResponse
}