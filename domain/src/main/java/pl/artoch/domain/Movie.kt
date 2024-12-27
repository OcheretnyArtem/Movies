package pl.artoch.domain

data class Movie(
    val id: Id,
    val name: String,
    val imageUrl: String?
) {

    data class Id(val value: String)
}
