package done.it.moview.data.api

import done.it.moview.data.api.responses.MovieListResponse
import done.it.moview.data.entities.MovieDetailsItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("discover/movie")
    fun getMovies(): Single<MovieListResponse>

    @GET("search/movie")
    fun findMovies(@Query("query") text: String): Single<MovieListResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetailsItem>
}