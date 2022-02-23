package softing.ubah4ukdev.mymovies.data.repository

import softing.ubah4ukdev.mymovies.data.repository.datasource.RemoteDataSource
import softing.ubah4ukdev.mymovies.domain.AppState
import softing.ubah4ukdev.mymovies.domain.models.ActorsResponse
import softing.ubah4ukdev.mymovies.domain.models.MovieResponse
import softing.ubah4ukdev.mymovies.domain.models.MoviesResponse
import softing.ubah4ukdev.mymovies.domain.repository.MovieRepository

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
class MovieRepositoryImpl(private val dataSource: RemoteDataSource) : MovieRepository {
    override suspend fun getMoviesTopRated(adult: Boolean, page: Int): AppState<MoviesResponse> =
        dataSource.getMoviesTopRated(adult, page)

    override suspend fun getMovieDetailById(movieId: Int): AppState<MovieResponse> =
        dataSource.getMovieDetailById(movieId)

    override suspend fun getActorsList(movieId: Int): AppState<ActorsResponse> =
        dataSource.getActorsList(movieId)

    override suspend fun searchMovie(query: String): AppState<MoviesResponse> =
        dataSource.searchMovie(query)
}