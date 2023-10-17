package com.enescanpolat.composecleanarchitecturewallpaperapp

sealed class Screen(val route:String){
    object ArtListScreen:Screen("ArtListScreen")
    object ArtDetailScreen:Screen("ArtDetailScreen")
}
