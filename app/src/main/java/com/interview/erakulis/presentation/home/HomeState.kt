package com.interview.erakulis.presentation.home

import com.interview.erakulis.domain.Image


sealed class HomeState {
    object Loading : HomeState()
    data class Success(val images: List<Image>) : HomeState()
    data class Error(val message: String) : HomeState()
}
