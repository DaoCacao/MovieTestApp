package done.it.moview.features.movieList

import dagger.Binds
import dagger.Module
import done.it.moview.base.BaseActivity
import done.it.moview.base.BasePresenter
import javax.inject.Inject

class MovieListActivity : BaseActivity<Presenter>(), View

class MovieListPresenter @Inject constructor() : BasePresenter<View>(), Presenter

@Module
interface MovieListModule {

    @Binds
    fun view(view: MovieListActivity): View

    @Binds
    fun presenter(presenter: MovieListPresenter): Presenter
}
