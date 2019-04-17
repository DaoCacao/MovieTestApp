package done.it.moview.features.details

import done.it.moview.base.BasePresenter
import done.it.moview.data.repo.Repository
import done.it.moview.extentions.saveSubscribe
import done.it.moview.extentions.scheduleIo
import javax.inject.Inject

class DetailsPresenter @Inject constructor() : BasePresenter<View>(), Presenter {

    @Inject lateinit var repository: Repository

    override fun onViewInit(movieId: Int) {
        repository.getMovieDetails(movieId)
            .scheduleIo()
            .saveSubscribe(view::showDetails)
    }
}