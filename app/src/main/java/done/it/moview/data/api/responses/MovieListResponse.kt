package done.it.moview.data.api.responses

import done.it.moview.data.entities.MovieListItem

class MovieListResponse(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<MovieListItem>
)