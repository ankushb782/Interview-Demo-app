package com.interview.erakulis.domain


sealed class ImageDetailState {
    object Loading : ImageDetailState()
    data class Success(val imageDetail: ImageDetail) : ImageDetailState()
    data class Error(val message: String) : ImageDetailState()
}
