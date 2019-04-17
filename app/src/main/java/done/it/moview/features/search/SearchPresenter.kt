package done.it.moview.features.search

import done.it.moview.base.BasePresenter
import done.it.moview.data.repo.Repository
import done.it.moview.extentions.saveSubscribe
import done.it.moview.extentions.scheduleIo
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Inject

class SearchPresenter @Inject constructor() : BasePresenter<View>(), Presenter {

    @Inject lateinit var repository: Repository

    private val searchDelaySec = 1L
    private var disposable: Disposable? = null

    override fun onTextChanged(text: String) {
        disposable?.dispose()

        if (text.isEmpty()) return

        view.showLoading()

        disposable = Single.timer(searchDelaySec, SECONDS)
            .flatMap { repository.findMovies(text) }
            .scheduleIo()
            .saveSubscribe { movies ->
                if (movies.isEmpty()) view.showNoResults()
                else view.showResults(movies)
            }
    }
}