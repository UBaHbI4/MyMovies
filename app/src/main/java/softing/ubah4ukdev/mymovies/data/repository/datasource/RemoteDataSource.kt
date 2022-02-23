package softing.ubah4ukdev.mymovies.data.repository.datasource

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
interface RemoteDataSource {
    suspend fun getMoviesTopRated(adult: Boolean, page: Int): AppState<MoviesResponse>
    suspend fun getMovieDetailById(movieId: Int): AppState<MovieResponse>
    suspend fun getActorsList(movieId: Int): AppState<ActorsResponse>
}