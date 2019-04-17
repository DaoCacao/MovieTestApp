package done.it.moview.data.repo

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface MovieRepositoryModule {

    @Binds
    @Singleton
    fun repository(repository: MovieRepository): Repository
}