package com.enescanpolat.composecleanarchitecturewallpaperapp.domain.usecases

import com.enescanpolat.composecleanarchitecturewallpaperapp.data.dto.imageResponseList
import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.model.imageResponse
import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.repository.artRepository
import com.enescanpolat.composecleanarchitecturewallpaperapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class getArtsUseCase @Inject constructor(private val repository: artRepository){



    fun executeGetArts(search:String): Flow<Resource<List<imageResponse>>> = flow{

        try {
            emit(Resource.Loading())
            val artList = repository.getArts(search)
            emit(Resource.Success(artList.imageResponseList()))





        }catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage?:"Error"))
        }catch (e:IOException){
            emit(Resource.Error(e.localizedMessage?:"Error"))
        }


    }


}