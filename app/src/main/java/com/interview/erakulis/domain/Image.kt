package com.interview.erakulis.domain

data class Image(
    val id: String,
    val user: String,
    val imageUrl: String,
    val tags: List<String>
)
