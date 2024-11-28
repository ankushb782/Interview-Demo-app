package com.interview.erakulis.data

import com.interview.erakulis.domain.Image
import com.interview.erakulis.domain.ImageDetail

class ImageRepositoryImpl : ImageRepository {

    override suspend fun getImages(page: Int, perPage: Int): List<Image> {
        // Mocked response for demonstration
        return List(perPage) { index ->
            Image(
                id = "$page-${index + 1}",
                user = "User ${page * 10 + index}",
                imageUrl = "https://via.placeholder.com/150",
                tags = listOf("tag${index + 1}", "mock", "image")
            )
        }
    }

    override suspend fun getImageDetail(imageId: String): ImageDetail {
        // Mocked response for image details
        return ImageDetail(
            id = imageId,
            user = "John Doe",
            imageUrl = "https://via.placeholder.com/600",
            size = "600x400",
            type = "JPG",
            tags = listOf("nature", "scenery", "landscape"),
            views = 1234,
            likes = 567,
            comments = 89,
            favorites = 100,
            downloads = 300
        )
    }
}
