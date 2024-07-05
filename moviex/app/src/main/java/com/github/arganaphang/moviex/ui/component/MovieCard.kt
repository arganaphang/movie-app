package com.github.arganaphang.moviex.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.github.arganaphang.moviex.entity.Movie
import com.github.arganaphang.moviex.ui.theme.MoviexTheme


@Composable
fun MovieCard(movie: Movie) {
    var isBookmarked by remember { mutableStateOf(false) }
    Box {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(160.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://image.tmdb.org/t/p/original${movie.posterPath}")
                        .crossfade(true)
                        .build(),
                    modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    placeholder = BrushPainter(
                        with(Brush) {
                            linearGradient(
                                listOf(
                                    Color(color = 0xFFD0D5FF),
                                    Color(color = 0xFF71A5FF),
                                )
                            )
                        }
                    ),
                )
                Box(
                    modifier = Modifier.align(Alignment.TopEnd),
                ) {
                    IconButton(onClick = {
                        isBookmarked = !isBookmarked
                    }) {
                        val icon = if (!isBookmarked) {
                            Icons.Default.FavoriteBorder
                        } else {
                            Icons.Default.Favorite
                        }
                        Icon(icon, contentDescription = "bookmark")
                    }
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(movie.title, style = MaterialTheme.typography.titleLarge)
                Text("${movie.voteAverage}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Preview
@Composable
fun MovieCardPreview() {
    val movie = Movie(
        1,
        "Inside Out 2",
        "Teenager Riley's mind headquarters is undergoing a sudden demolition to make room for something entirely unexpected: new Emotions! Joy, Sadness, Anger, Fear and Disgust, who’ve long been running a successful operation by all accounts, aren’t sure how to feel when Anxiety shows up. And it looks like she’s not alone.",
        7.71,
        "/vpnVM9B6NMmQpWeZvzLvDESb2QY.jpg",
        "/xg27NrXi7VXCGUr7MG75UqLl6Vg.jpg",
    )

    MoviexTheme { MovieCard(movie) }
}