package pl.artoch.movies.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import pl.artoch.domain.fakes.fakeMovie
import pl.artoch.movies.android.screens.MoviesListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*TODO Delete*/
                    val movies = List(4) { fakeMovie(id = "$it") }
                    MoviesListScreen(movies)
                }
            }
        }
    }
}
