package softing.ubah4ukdev.mymovies.domain.repository

import softing.ubah4ukdev.mymovies.domain.AppState
import softing.ubah4ukdev.mymovies.domain.models.MoviesResponse

/**
 *   Project: MyMovies
 *
 *   Package: softing.ubah4ukdev.mymovies.domain.repository
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
interface MovieRepository {
    suspend fun getMoviesTopRated(adult: Boolean, page: Int): AppState<MoviesResponse>
}