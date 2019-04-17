package done.it.moview.features.search

import dagger.Binds
import dagger.Module
import done.it.moview.movieAdapter.MovieAdapterModule

@Module(includes = [MovieAdapterModule::class])
interface SearchModule {

    @Binds
    fun view(view: SearchActivity): View

    @Binds
    fun presenter(presenter: SearchPresenter): Presenter
}