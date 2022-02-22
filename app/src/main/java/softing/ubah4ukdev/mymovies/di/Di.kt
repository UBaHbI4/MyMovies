package softing.ubah4ukdev.mymovies.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import softing.ubah4ukdev.mymovies.ui.detail.DetailViewModel
import softing.ubah4ukdev.mymovies.ui.movies.MoviesViewModel
import softing.ubah4ukdev.mymovies.ui.settings.SettingsViewModel

/**
 *   Project: MyMovies
 *
 *   Package: softing.ubah4ukdev.mymovies.di
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
object Di {
    fun viewModelModule() = module {

        viewModel() {
            MoviesViewModel()
        }

        viewModel() {
            DetailViewModel()
        }

        viewModel() {
            SettingsViewModel()
        }
    }
}