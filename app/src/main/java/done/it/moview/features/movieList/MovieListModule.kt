package done.it.moview.features.movieList

import dagger.Binds
import dagger.Module
import done.it.moview.movieAdapter.MovieAdapterModule

@Module(includes = [MovieAdapterModule::class])
abstract class MovieListModule {

    @Binds
    abstract fun view(view: MovieListActivity): View

    @Binds
    abstract fun presenter(presenter: MovieListPresenter): Presenter
}