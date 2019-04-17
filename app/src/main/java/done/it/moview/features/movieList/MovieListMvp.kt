package done.it.moview.features.movieList

import done.it.moview.base.MvpPresenter
import done.it.moview.base.MvpView
import done.it.moview.data.entities.MovieListItem

interface View : MvpView {
    fun showMovies(movies: List<MovieListItem>)
    fun navigateToSearch()
}

interface Presenter : MvpPresenter {
    fun onViewInit()
    fun onSearchClick()
}