package com.enescanpolat.composecleanarchitecturewallpaperapp.data.repository

import androidx.lifecycle.LiveData
import com.enescanpolat.composecleanarchitecturewallpaperapp.data.datasource.api.RetrofitAPI
import com.enescanpolat.composecleanarchitecturewallpaperapp.data.dto.imageResponseDTO
import com.enescanpolat.composecleanarchitecturewallpaperapp.data.dto.imageResultDTO
import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.repository.artRepository
import com.enescanpolat.composecleanarchitecturewallpaperapp.util.Resource
import javax.inject.Inject

class artRepositoryImpl @Inject constructor(
    private val retrofitAPI: RetrofitAPI
) :artRepository{
    override suspend fun getArts(search: String): imageResponseDTO {
        return retrofitAPI.getImages(search)
    }

    override suspend fun getArtDetail(imageId: Int): imageResponseDTO{
        return retrofitAPI.imageDetail(imageId=imageId)
    }


}