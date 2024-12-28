package pl.artoch.movies.android.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pl.artoch.domain.fakes.fakeMovie
import pl.artoch.domain.models.Movie
import pl.artoch.movies.android.R

@Composable
fun MoviesListScreen(movies: List<Movie>, onMovieClick: (Movie) -> Unit, onLikeClick: (Movie) -> Unit) {
    val movies1 = remember { movies }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        movies1.forEach {
            MovieCard(it, onMovieClick, onLikeClick)
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun MovieCard(movie: Movie, onClick: (Movie) -> Unit, onLikeClick: (Movie) -> Unit) {
    Card(shape = RoundedCornerShape(12.dp), onClick = { onClick(movie) }) {
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = movie.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .size(100.dp)
            )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = movie.name)
                val description = movie.description
                if (description != null) {
                    Text(text = description)
                }
            }
            val iconColor = if (movie.isFavorite) Color.Green else Color.Red
            Icon(
                modifier = Modifier.clickable(role = Image) { onLikeClick(movie) },
                painter = painterResource(R.drawable.ic_favorite),
                contentDescription = null,
                tint = iconColor
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun MoviesListScreenPreview() {
    val movies = List(4) { fakeMovie(id = "$it") }
    MoviesListScreen(
        movies = movies,
        onMovieClick = {},
        onLikeClick = {}
    )
}
