package done.it.moview.app

import android.content.Context
import dagger.Binds
import dagger.Module

@Module
interface AppModule {

    @Binds
    fun context(app: App): Context
}