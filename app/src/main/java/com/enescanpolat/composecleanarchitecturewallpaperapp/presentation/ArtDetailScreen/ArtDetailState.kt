package com.enescanpolat.composecleanarchitecturewallpaperapp.presentation.ArtDetailScreen

import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.model.imageDetail
import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.model.imageResponse

data class ArtDetailState (
    val isloading:Boolean=false,
    val art:imageResponse?=null,
    val error:String=""
        )
