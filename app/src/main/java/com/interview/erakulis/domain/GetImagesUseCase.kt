package com.interview.erakulis.domain

import com.interview.erakulis.data.ImageRepository

class GetImagesUseCase (
    private val imageRepository: ImageRepository
) {

    suspend fun execute(page: Int, perPage: Int): List<Image> {
        return imageRepository.getImages(page, perPage)
    }
}
