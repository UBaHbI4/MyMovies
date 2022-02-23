package softing.ubah4ukdev.mymovies.data.repository.datasource

import softing.ubah4ukdev.mymovies.data.api.MovieApi
import softing.ubah4ukdev.mymovies.domain.AppState
import softing.ubah4ukdev.mymovies.domain.models.ActorsResponse
import softing.ubah4ukdev.mymovies.domain.models.MovieResponse
import softing.ubah4ukdev.mymovies.domain.models.MoviesResponse

/**
 *   Project: MyMovies
 *
 *   Package: softing.ubah4ukdev.mymovies.data.repository.datasource
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
class RemoteDataSourceImpl(private val movieApi: MovieApi) : RemoteDataSource {
    override suspend fun getMoviesTopRated(adult: Boolean, page: Int): AppState<MoviesResponse> =
        try {
            val result = movieApi.getMoviesTopRatedAsync(adult, page).await()

            if (result.movies.isNotEmpty()) {
                AppState.Success(result)
            } else {
                AppState.Error(Exception(NO_DATA))
            }
        } catch (err: Exception) {
            AppState.Error(err)
        }

    override suspend fun getMovieDetailById(movieId: Int): AppState<MovieResponse> =
        try {
            val result = movieApi.getMovieDetailByIdAsync(movieId).await()
            AppState.Success(result)
        } catch (err: Exception) {
            AppState.Error(err)
        }

    override suspend fun getActorsList(movieId: Int): AppState<ActorsResponse> =
        try {
            val result = movieApi.getActorsListAsync(movieId).await()

            if (result.cast.isNotEmpty()) {
                AppState.Success(result)
            } else {
                AppState.Error(Exception(NO_DATA))
            }
        } catch (err: Exception) {
            AppState.Error(err)
        }

    companion object {
        const val NO_DATA = "Отсутствуют данные"
    }
}