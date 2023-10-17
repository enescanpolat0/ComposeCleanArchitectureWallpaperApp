package com.enescanpolat.composecleanarchitecturewallpaperapp.domain.model

data class imageResponse(
    val downloads: Int,
    val id: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val imageWidth: Int,
    val largeImageURL: String,
    val pageURL: String,
    val previewHeight: Int,
    val previewURL: String,
    val previewWidth: Int,
    val likes: Int,
    val tags: String,
    val type: String,
    val user_id: Int,
    val views: Int,
    val webformatURL: String,
)
