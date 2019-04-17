package done.it.moview.features.details

import dagger.Binds
import dagger.Module

@Module
interface DetailsModule {

    @Binds
    fun view(view: DetailsActivity): View

    @Binds
    fun presenter(presenter: DetailsPresenter): Presenter
}