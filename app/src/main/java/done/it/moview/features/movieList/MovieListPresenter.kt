package done.it.moview.features.movieList

import done.it.moview.base.BasePresenter
import done.it.moview.data.repo.Repository
import done.it.moview.extentions.saveSubscribe
import done.it.moview.extentions.scheduleIo
import javax.inject.Inject

class MovieListPresenter @Inject constructor() : BasePresenter<View>(), Presenter {

    @Inject lateinit var repository: Repository

    override fun onViewInit() {
        repository.getMovies()
            .scheduleIo()
            .saveSubscribe(view::showMovies)
    }

    override fun onSearchClick() = view.navigateToSearch()

}