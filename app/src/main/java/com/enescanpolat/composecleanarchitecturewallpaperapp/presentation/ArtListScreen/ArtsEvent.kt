package com.enescanpolat.composecleanarchitecturewallpaperapp.presentation.ArtListScreen

sealed class ArtsEvent{
    data class search(val search:String):ArtsEvent()
}
