package com.interview.erakulis.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.erakulis.domain.GetImagesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getImagesUseCase: GetImagesUseCase
) : ViewModel() {

    private val _imageList = androidx.lifecycle.MutableLiveData<HomeState>()
    val imageList: androidx.lifecycle.LiveData<HomeState> = _imageList

    fun fetchImages() {
        _imageList.value = HomeState.Loading

        viewModelScope.launch {
            try {
                val images = getImagesUseCase.execute(page = 1, perPage = 10) // Paginate here
                _imageList.value = HomeState.Success(images)
            } catch (e: Exception) {
                _imageList.value = HomeState.Error(e.message ?: "Unknown error")
            }
        }
    }

    // Retry function to reload images
    fun retry() {
        fetchImages() // Simply call the loadImages function again to retry fetching the images
    }
}
