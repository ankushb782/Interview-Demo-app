package com.interview.erakulis.presentation.image_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.erakulis.domain.GetImageDetailUseCase
import com.interview.erakulis.domain.ImageDetailState
import kotlinx.coroutines.launch

class ImageDetailViewModel(
    private val getImageDetailUseCase: GetImageDetailUseCase
) : ViewModel() {

    private val _imageDetailState = MutableLiveData<ImageDetailState>()
    val imageDetailState: LiveData<ImageDetailState> = _imageDetailState

    fun fetchImageDetail(imageId: String) {
        _imageDetailState.value = ImageDetailState.Loading

        viewModelScope.launch {
            try {
                val imageDetail = getImageDetailUseCase.execute(imageId)
                _imageDetailState.value = ImageDetailState.Success(imageDetail)
            } catch (e: Exception) {
                _imageDetailState.value = ImageDetailState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
