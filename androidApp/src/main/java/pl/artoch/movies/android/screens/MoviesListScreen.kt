package pl.artoch.movies.android.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pl.artoch.domain.fakes.fakeMovie
import pl.artoch.domain.models.Movie

@Composable
fun MoviesListScreen(movies: List<Movie>) {
    Column {
        movies.forEach {
            MovieCard(it)
        }
    }
}

@Composable
private fun MovieCard(movie: Movie) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        AsyncImage(model = movie.imageUrl, contentDescription = null)
        Column {
            Text(text = movie.name)
            val description = movie.description
            if (description != null) {
                Text(text = description)
            }
        }
    }
}

@Preview
@Composable
private fun MoviesListScreenPreview() {
    val movies = List(4) { fakeMovie(id = "$it") }
    MoviesListScreen(movies)
    MovieCard(fakeMovie())
}
