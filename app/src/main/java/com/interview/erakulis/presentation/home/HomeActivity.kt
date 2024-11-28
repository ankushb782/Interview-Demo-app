package com.interview.erakulis.presentation.home

import ImageAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.interview.erakulis.databinding.ActivityHomeBinding
import com.interview.erakulis.presentation.image_detail.ImageDetailActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()  // Koin ViewModel injection

    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup RecyclerView
        imageAdapter = ImageAdapter { image ->
            // Navigate to Image Detail on item click
            val intent = Intent(this, ImageDetailActivity::class.java)
            intent.putExtra("imageId", image.id)
            startActivity(intent)
        }

        binding.imageListRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.imageListRecyclerView.adapter = imageAdapter

        // Observe the images list
        homeViewModel.imageList.observe(this, Observer { state ->
            when (state) {
                is HomeState.Loading -> {
                    binding.progressBar.visibility = android.view.View.VISIBLE
                }
                is HomeState.Success -> {
                    binding.progressBar.visibility = android.view.View.GONE
                    imageAdapter.submitList(state.images)
                }
                is HomeState.Error -> {
                    binding.progressBar.visibility = android.view.View.GONE
                    Toast.makeText(this, "Error loading images: ${state.message}", Toast.LENGTH_SHORT).show()
                }
            }
        })

        // Trigger fetching images
        homeViewModel.fetchImages()
    }
}
