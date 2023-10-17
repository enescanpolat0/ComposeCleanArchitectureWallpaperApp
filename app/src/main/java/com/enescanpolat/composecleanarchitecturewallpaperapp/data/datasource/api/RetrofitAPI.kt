package com.enescanpolat.composecleanarchitecturewallpaperapp.data.datasource.api

import com.enescanpolat.composecleanarchitecturewallpaperapp.data.dto.imageResponseDTO
import com.enescanpolat.composecleanarchitecturewallpaperapp.data.dto.imageResultDTO
import com.enescanpolat.composecleanarchitecturewallpaperapp.util.Constants.API_KEY

import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {

    @GET("/api/")
    suspend fun getImages(
        @Query("q") searchQuery:String,
        @Query("key") apiKey:String=API_KEY
    ):imageResponseDTO

    @GET("/api/")
    suspend fun imageDetail(
        @Query("key") apiKey: String = API_KEY,
        @Query("id") imageId:Int,
    ):imageResponseDTO

}