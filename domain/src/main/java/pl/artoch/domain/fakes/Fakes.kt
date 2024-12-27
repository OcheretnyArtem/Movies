package pl.artoch.domain.fakes

import pl.artoch.domain.models.Movie

fun fakeMovie(
    id: String = "1",
    name: String = "Fake Movie $id",
    description: String? = "Fake description",
    imageUrl: String? = "https://image.tmdb.org/t/p/w500/cdqLnri3NEGcmfnqwk2TSIYtddg.jpg"
) = Movie(id = Movie.Id(id), name = name, description = description, imageUrl = imageUrl)
