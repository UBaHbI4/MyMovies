package softing.ubah4ukdev.mymovies.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import softing.ubah4ukdev.mymovies.di.Di

/**
 *   Project: MyMovies
 *
 *   Package: softing.ubah4ukdev.mymovies.application
 *
 *   Created by Ivan Sheynmaer
 *
 *   Description:
 *
 *
 *   2022.02.22
 *
 *   v1.0
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    Di.viewModelModule()
                )
            )
        }
    }
}