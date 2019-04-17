package done.it.moview.features.details

import done.it.moview.base.MvpPresenter
import done.it.moview.base.MvpView
import done.it.moview.data.entities.MovieDetailsItem

interface View : MvpView {
    fun showDetails(details: MovieDetailsItem)
}

interface Presenter : MvpPresenter {
    fun onViewInit(movieId: Int)
}