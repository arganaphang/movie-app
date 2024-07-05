package com.github.arganaphang.moviex.entity

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val voteAverage: Double,
    val posterPath: String,
    val backdropPath: String,
    val isBookmarked: Boolean = false,
)
