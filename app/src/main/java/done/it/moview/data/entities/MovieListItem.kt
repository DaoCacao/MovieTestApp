package done.it.moview.data.entities

class MovieListItem(
    val vote_count: Int,
    val id: Int,
    val vote_average: Double,
    val title: String,
    val poster_path: String,
    val overview: String,
    val release_date: String
)