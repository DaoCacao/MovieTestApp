package done.it.moview.features.search

import dagger.Binds
import dagger.Module
import done.it.moview.base.BaseActivity
import done.it.moview.base.BasePresenter
import javax.inject.Inject

class SearchActivity : BaseActivity<Presenter>(), View

class SearchPresenter @Inject constructor() : BasePresenter<View>(), Presenter

@Module
interface SearchModule {

    @Binds
    fun view(view: SearchActivity): View

    @Binds
    fun presenter(presenter: SearchPresenter): Presenter
}