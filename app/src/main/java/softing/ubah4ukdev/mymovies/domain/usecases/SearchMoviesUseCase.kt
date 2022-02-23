package softing.ubah4ukdev.mymovies.domain.usecases

import softing.ubah4ukdev.mymovies.domain.AppState
import softing.ubah4ukdev.mymovies.domain.models.MoviesResponse
import softing.ubah4ukdev.mymovies.domain.repository.MovieRepository

/**
 *   Project: MyMapApplication
 *
 *   Package: softing.ubah4ukdev.mymapapplication.domain.uscases
 *
 *   Created by Ivan Sheynmaer
 *
 *   Description:
 *
 *
 *   2022.02.19
 *
 *   v1.0
 */
class SearchMoviesUseCase(private val repository: MovieRepository) {
    suspend fun execute(query: String): AppState<MoviesResponse> =
        repository.searchMovie(query)
}