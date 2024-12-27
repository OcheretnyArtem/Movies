package pl.artoch.domain.fakes

import pl.artoch.domain.models.Movie

fun fakeMovie(
    id: String = "1",
    name: String = "Fake Movie $id",
    imageUrl: String? = null
) = Movie(id = Movie.Id(id), name = name, imageUrl = imageUrl)
