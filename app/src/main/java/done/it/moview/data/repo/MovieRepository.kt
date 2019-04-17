package done.it.moview.data.repo

import android.util.LruCache
import done.it.moview.data.api.MovieApi
import done.it.moview.data.entities.MovieDetailsItem
import done.it.moview.data.entities.MovieListItem
import io.reactivex.Single
import javax.inject.Inject

class MovieRepository @Inject constructor() : Repository {

    @Inject lateinit var movieApi: MovieApi

    private lateinit var moviesListItems: List<MovieListItem>

    private val movies = LruCache<Int, MovieDetailsItem>(100)

    override fun getMovies(): Single<List<MovieListItem>> {
        return if (::moviesListItems.isInitialized) Single.just(moviesListItems)
        else movieApi.getMovies().map { moviesListItems = it.results; moviesListItems }
    }

    override fun findMovies(text: String): Single<List<MovieListItem>> = movieApi.findMovies(text).map { it.results }

    override fun getMovieDetails(id: Int): Single<MovieDetailsItem> {
        return movies[id].let {
            if (it != null) Single.just(it)
            else movieApi.getMovieDetails(id).map { movie -> movies.put(id, movie); movie }
        }
    }
}