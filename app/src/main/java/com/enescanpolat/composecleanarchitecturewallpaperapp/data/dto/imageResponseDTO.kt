package com.enescanpolat.composecleanarchitecturewallpaperapp.data.dto

import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.model.imageResponse

data class imageResponseDTO(
    val hits: List<imageResultDTO>,
    val total: Int,
    val totalHits: Int
)

fun imageResponseDTO.imageResponseList(): List<imageResponse> {
    return hits.map {hits->

        imageResponse(
            hits.downloads,
            hits.id,
            hits.imageHeight,
            hits.imageSize,
            hits.imageWidth,
            hits.largeImageURL,
            hits.pageURL,
            hits.previewHeight,
            hits.previewURL,
            hits.previewWidth,
            hits.likes,
            hits.tags,
            hits.type,
            hits.user_id,
            hits.views,
            hits.webformatURL)

    }
}
fun imageResponseDTO.toimageResponse(): imageResponse {
    val firstHit = hits.firstOrNull()
    return if (firstHit != null) {
        imageResponse(
            firstHit.downloads,
            firstHit.id,
            firstHit.imageHeight,
            firstHit.imageSize,
            firstHit.imageWidth,
            firstHit.largeImageURL,
            firstHit.pageURL,
            firstHit.previewHeight,
            firstHit.previewURL,
            firstHit.previewWidth,
            firstHit.likes,
            firstHit.tags,
            firstHit.type,
            firstHit.user_id,
            firstHit.views,
            firstHit.webformatURL
        )
    } else {

        imageResponse(
            downloads = 0,
            id = 0,
            imageHeight = 0,
            imageSize = 0,
            imageWidth = 0,
            largeImageURL = "",
            pageURL = "",
            previewHeight = 0,
            previewURL = "",
            previewWidth = 0,
            likes = 0,
            tags = "",
            type = "",
            user_id = 0,
            views = 0,
            webformatURL = ""
        )
    }
}













