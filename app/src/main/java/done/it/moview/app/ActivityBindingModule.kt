package done.it.moview.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import done.it.moview.features.details.DetailsActivity
import done.it.moview.features.details.DetailsModule
import done.it.moview.features.movieList.MovieListActivity
import done.it.moview.features.movieList.MovieListModule
import done.it.moview.features.search.SearchActivity
import done.it.moview.features.search.SearchModule

@Module
interface ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MovieListModule::class])
    fun movieList(): MovieListActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [DetailsModule::class])
    fun details(): DetailsActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SearchModule::class])
    fun search(): SearchActivity
}