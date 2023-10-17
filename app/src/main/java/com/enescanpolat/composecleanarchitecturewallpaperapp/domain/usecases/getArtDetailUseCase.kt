package com.enescanpolat.composecleanarchitecturewallpaperapp.domain.usecases

import com.enescanpolat.composecleanarchitecturewallpaperapp.data.dto.toimageDetail
import com.enescanpolat.composecleanarchitecturewallpaperapp.data.dto.toimageResponse
import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.model.imageDetail
import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.model.imageResponse
import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.repository.artRepository
import com.enescanpolat.composecleanarchitecturewallpaperapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class getArtDetailUseCase @Inject constructor(private val repository: artRepository) {



    fun executegetArtDetail(imageId:Int): Flow<Resource<imageResponse>> =flow{

        try {
            emit(Resource.Loading())
            val artDetail = repository.getArtDetail(imageId).toimageResponse()
            emit(Resource.Success(artDetail))

        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?:"Error"))
        }catch (e:IOException){
            emit(Resource.Error(e.localizedMessage?:"Error"))
        }


    }



}