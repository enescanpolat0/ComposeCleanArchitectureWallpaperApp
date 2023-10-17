package com.enescanpolat.composecleanarchitecturewallpaperapp.domain.repository

import androidx.lifecycle.LiveData
import com.enescanpolat.composecleanarchitecturewallpaperapp.data.dto.imageResponseDTO
import com.enescanpolat.composecleanarchitecturewallpaperapp.data.dto.imageResultDTO
import com.enescanpolat.composecleanarchitecturewallpaperapp.util.Resource

interface artRepository {



    suspend fun getArts(search:String):imageResponseDTO

    suspend fun getArtDetail(imageId:Int):imageResponseDTO


}