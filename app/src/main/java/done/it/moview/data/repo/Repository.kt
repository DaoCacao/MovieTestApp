package done.it.moview.data.repo

import done.it.moview.data.entities.MovieDetailsItem
import done.it.moview.data.entities.MovieListItem
import io.reactivex.Single

interface Repository {
    fun getMovies(): Single<List<MovieListItem>>
    fun findMovies(text: String): Single<List<MovieListItem>>
    fun getMovieDetails(id: Int): Single<MovieDetailsItem>
}