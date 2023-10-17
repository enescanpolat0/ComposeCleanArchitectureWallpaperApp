package com.enescanpolat.composecleanarchitecturewallpaperapp.presentation.ArtListScreen

import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.model.imageResponse

data class ArtsState(
    val isLoading :Boolean= false,
    val arts:List<imageResponse> = emptyList(),
    val error : String="",
    val search:String="red"
)
