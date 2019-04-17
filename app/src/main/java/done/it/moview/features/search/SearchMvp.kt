package done.it.moview.features.search

import done.it.moview.base.MvpPresenter
import done.it.moview.base.MvpView
import done.it.moview.data.entities.MovieListItem

interface View : MvpView {
    fun showLoading()
    fun showNoResults()
    fun showResults(movies: List<MovieListItem>)
}

interface Presenter : MvpPresenter {
    fun onTextChanged(text: String)
}