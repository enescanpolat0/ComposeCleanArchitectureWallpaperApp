package com.enescanpolat.composecleanarchitecturewallpaperapp.data.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.enescanpolat.composecleanarchitecturewallpaperapp.data.datasource.api.RetrofitAPI
import com.enescanpolat.composecleanarchitecturewallpaperapp.data.repository.artRepositoryImpl
import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.repository.artRepository
import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.usecases.getArtDetailUseCase
import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.usecases.getArtsUseCase
import com.enescanpolat.composecleanarchitecturewallpaperapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object appModule {





    @Singleton
    @Provides
    fun injectRetrofitAPI():RetrofitAPI{

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(RetrofitAPI::class.java)


    }

    @Singleton
    @Provides
    fun injectArtRepository(api:RetrofitAPI): artRepository{
        return artRepositoryImpl(api)
    }



    @Singleton
    @Provides
    fun injectgetArtsUseCase(repository: artRepository):getArtsUseCase{
        return getArtsUseCase(repository)
    }

    @Singleton
    @Provides
    fun injectgetArtDetailUseCase(repository: artRepository):getArtDetailUseCase{
        return getArtDetailUseCase(repository)
    }


}