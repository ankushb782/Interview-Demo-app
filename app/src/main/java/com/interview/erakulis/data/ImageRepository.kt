package com.interview.erakulis.data

import com.interview.erakulis.domain.Image
import com.interview.erakulis.domain.ImageDetail


interface ImageRepository {
    suspend fun getImages(page: Int, perPage: Int): List<Image>
    suspend fun getImageDetail(imageId: String): ImageDetail

}
