package com.enescanpolat.composecleanarchitecturewallpaperapp.data.dto

import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.model.imageDetail

data class imageResultDTO(
    val collections: Int,
    val comments: Int,
    val downloads: Int,
    val id: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val imageWidth: Int,
    val largeImageURL: String,
    val likes: Int,
    val pageURL: String,
    val previewHeight: Int,
    val previewURL: String,
    val previewWidth: Int,
    val tags: String,
    val type: String,
    val user: String,
    val userImageURL: String,
    val user_id: Int,
    val views: Int,
    val webformatHeight: Int,
    val webformatURL: String,
    val webformatWidth: Int
)

fun imageResultDTO.toimageDetail():imageDetail{
    return imageDetail(
        downloads,
        id,
        imageHeight,
        imageSize,
        imageWidth,
        largeImageURL,
        likes,
        pageURL,
        previewHeight,
        previewURL,
        previewWidth,
        tags,
        type,
        user_id,
        views,
        webformatHeight,
        webformatURL,
        webformatWidth)
}
