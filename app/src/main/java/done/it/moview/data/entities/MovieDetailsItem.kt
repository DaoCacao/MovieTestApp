package done.it.moview.data.entities

class MovieDetailsItem(
    val genres: Array<Genre>,
    val homepage: String,
    val id: Int,
    val overview: String,
    val poster_path: String,
    val production_companies: Array<Company>,
    val tagline: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
)