package com.interview.erakulis.domain

import com.interview.erakulis.data.ImageRepository

class GetImageDetailUseCase(
    private val imageRepository: ImageRepository
) {

    suspend fun execute(imageId: String): ImageDetail {
        return imageRepository.getImageDetail(imageId)
    }
}
