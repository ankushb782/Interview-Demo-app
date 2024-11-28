package com.interview.erakulis.domain

data class ImageDetail(
    val id: String,
    val user: String,
    val imageUrl: String,
    val size: String,
    val type: String,
    val tags: List<String>,
    val views: Int,
    val likes: Int,
    val comments: Int,
    val favorites: Int,
    val downloads: Int
)
