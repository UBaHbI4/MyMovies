package softing.ubah4ukdev.mymovies.data.api

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import softing.ubah4ukdev.mymovies.BuildConfig
import softing.ubah4ukdev.mymovies.domain.models.ActorsResponse
import softing.ubah4ukdev.mymovies.domain.models.MovieResponse
import softing.ubah4ukdev.mymovies.domain.models.MoviesResponse

/**
 *   Project: MyMovies
 *
 *   Package: softing.ubah4ukdev.mymovies.data.api
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
interface MovieApi {

    @GET("movie/top_rated?api_key=${BuildConfig.MOVIE_API_KEY}&language=ru-RU")
    fun getMoviesTopRatedAsync(
        @Query("include_adult") adult: Boolean,
        @Query("page") page: Int
    ): Deferred<MoviesResponse>

    @GET("movie/{movie_id}?api_key=${BuildConfig.MOVIE_API_KEY}&language=ru-RU")
    fun getMovieDetailByIdAsync(@Path("movie_id") movieId: Int): Deferred<MovieResponse>

    @GET("movie/{movie_id}/casts?api_key=${BuildConfig.MOVIE_API_KEY}&language=ru-RU")
    fun getActorsListAsync(@Path("movie_id") movieId: Int): Deferred<ActorsResponse>

    @GET("search/movie?api_key=${BuildConfig.MOVIE_API_KEY}&language=ru-RU")
    fun searchMovieAsync(@Query("query") query: String): Deferred<MoviesResponse>
}