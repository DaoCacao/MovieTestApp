package done.it.moview.movieAdapter

import dagger.Module
import dagger.Provides

@Module
class MovieAdapterModule {

    @Provides
    fun adapter() = MovieAdapter()
}