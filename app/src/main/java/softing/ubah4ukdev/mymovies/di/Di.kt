package softing.ubah4ukdev.mymovies.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import softing.ubah4ukdev.mymovies.BuildConfig
import softing.ubah4ukdev.mymovies.data.api.ApiInterceptor
import softing.ubah4ukdev.mymovies.data.api.MovieApi
import softing.ubah4ukdev.mymovies.data.repository.MovieRepositoryImpl
import softing.ubah4ukdev.mymovies.data.repository.datasource.RemoteDataSource
import softing.ubah4ukdev.mymovies.data.repository.datasource.RemoteDataSourceImpl
import softing.ubah4ukdev.mymovies.domain.repository.MovieRepository
import softing.ubah4ukdev.mymovies.domain.usecases.GetActorsUseCase
import softing.ubah4ukdev.mymovies.domain.usecases.GetMovieDetailByIdUseCase
import softing.ubah4ukdev.mymovies.domain.usecases.GetMoviesTopRatedUseCase
import softing.ubah4ukdev.mymovies.ui.detail.DetailViewModel
import softing.ubah4ukdev.mymovies.ui.movies.MoviesViewModel
import softing.ubah4ukdev.mymovies.ui.settings.SettingsViewModel
import java.time.Duration

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
            MoviesViewModel(
                getMoviesTopRatedUseCase = get()
            )
        }

        viewModel() {
            DetailViewModel(
                getMovieDetailByIdUseCase = get(),
                getActorsUseCase = get()
            )
        }

        viewModel() {
            SettingsViewModel()
        }
    }

    fun apiModule() = module {
        single<Interceptor> {
            ApiInterceptor()
        }

        single<Gson> {
            GsonBuilder()
                .create()
        }

        single<MovieApi> {
            Retrofit.Builder()
                .baseUrl(BuildConfig.MOVIE_BASE_URL)
                .client(
                    OkHttpClient.Builder()
                        .callTimeout(Duration.ofSeconds(15))
                        .connectTimeout(Duration.ofSeconds(15))
                        .readTimeout(Duration.ofSeconds(15))
                        .writeTimeout(Duration.ofSeconds(15))
                        .addInterceptor(interceptor = get())
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                            if (BuildConfig.DEBUG) {
                                HttpLoggingInterceptor.Level.BODY
                            } else {
                                HttpLoggingInterceptor.Level.NONE
                            }
                        })
                        .build()
                )
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(get()))
                .build()
                .create(MovieApi::class.java)
        }
    }

    fun repositoryModule() = module {
        single<MovieRepository>() {
            MovieRepositoryImpl(
                dataSource = get()
            )
        }

        single<RemoteDataSource> {
            RemoteDataSourceImpl(movieApi = get())
        }
    }

    fun useCasesModule() = module {
        factory<GetMoviesTopRatedUseCase> {
            GetMoviesTopRatedUseCase(repository = get())
        }

        factory<GetMovieDetailByIdUseCase> {
            GetMovieDetailByIdUseCase(repository = get())
        }

        factory<GetActorsUseCase> {
            GetActorsUseCase(repository = get())
        }
    }

}