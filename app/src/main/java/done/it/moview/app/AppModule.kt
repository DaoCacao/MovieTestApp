package done.it.moview.app

import android.content.Context
import dagger.Module
import dagger.Provides
import done.it.moview.data.api.MovieApiModule
import done.it.moview.data.repo.MovieRepositoryModule
import javax.inject.Singleton

@Module(includes = [MovieApiModule::class, MovieRepositoryModule::class])
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun context() = context
}