package com.interview.erakulis.presentation.image_detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import coil.load
import com.interview.erakulis.databinding.ActivityImageDetailBinding
import com.interview.erakulis.domain.ImageDetail
import com.interview.erakulis.domain.ImageDetailState
import org.koin.androidx.viewmodel.ext.android.viewModel  // Koin's ViewModel injection

class ImageDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageDetailBinding
    private val imageDetailViewModel: ImageDetailViewModel by viewModel()  // Koin ViewModel injection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intent.getStringExtra("imageId") ?: return

        // Trigger fetching image details
        imageDetailViewModel.fetchImageDetail(imageId)

        // Observe the ImageDetailState
        imageDetailViewModel.imageDetailState.observe(this, Observer { state ->
            when (state) {
                is ImageDetailState.Loading -> {
                    binding.progressBar.visibility = android.view.View.VISIBLE
                }
                is ImageDetailState.Success -> {
                    binding.progressBar.visibility = android.view.View.GONE
                    bindImageDetail(state.imageDetail)
                }
                is ImageDetailState.Error -> {
                    binding.progressBar.visibility = android.view.View.GONE
                    binding.errorTextView.text = state.message
                    binding.errorTextView.visibility = android.view.View.VISIBLE
                }
            }
        })
    }

    private fun bindImageDetail(imageDetail: ImageDetail) {
        // Section 1 - Image Information
        binding.imageView.load(imageDetail.imageUrl) // Loading the image
        binding.sizeTextView.text = "Size: ${imageDetail.size}"
        binding.typeTextView.text = "Type: ${imageDetail.type}"
        binding.tagsTextView.text = "Tags: ${imageDetail.tags.joinToString(", ")}"

        // Section 2 - User Information
        binding.userNameTextView.text = "User: ${imageDetail.user}"
        binding.viewsTextView.text = "Views: ${imageDetail.views}"
        binding.likesTextView.text = "Likes: ${imageDetail.likes}"
        binding.commentsTextView.text = "Comments: ${imageDetail.comments}"
        binding.favoritesTextView.text = "Favorites: ${imageDetail.favorites}"
        binding.downloadsTextView.text = "Downloads: ${imageDetail.downloads}"
    }
}
