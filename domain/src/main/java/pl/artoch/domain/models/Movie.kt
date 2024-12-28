package pl.artoch.domain.models

data class Movie(
    val id: Id,
    val name: String,
    val imageUrl: String?,
    val description: String?,
    val isFavorite: Boolean
) {

    data class Id(val value: String)
}
