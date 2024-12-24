package pl.artoch.movies

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform