package done.it.moview.features.details

import dagger.Binds
import dagger.Module
import done.it.moview.base.BaseActivity
import done.it.moview.base.BasePresenter
import javax.inject.Inject

class DetailsActivity : BaseActivity<Presenter>(), View

class DetailsPresenter @Inject constructor() : BasePresenter<View>(), Presenter

@Module
interface DetailsModule {

    @Binds
    fun view(view: DetailsActivity): View

    @Binds
    fun presenter(presenter: DetailsPresenter): Presenter
}