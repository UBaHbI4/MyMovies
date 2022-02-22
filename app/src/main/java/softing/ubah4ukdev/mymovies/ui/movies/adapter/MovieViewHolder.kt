package softing.ubah4ukdev.mymovies.ui.movies.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import softing.ubah4ukdev.mymovies.BuildConfig
import softing.ubah4ukdev.mymovies.R
import softing.ubah4ukdev.mymovies.databinding.MovieItemBinding
import softing.ubah4ukdev.mymovies.domain.models.MoviesResponse
import softing.ubah4ukdev.mymovies.utils.extensions.click
import softing.ubah4ukdev.mymovies.utils.extensions.getColorByValue
import softing.ubah4ukdev.mymovies.utils.extensions.toDateString
import kotlin.math.roundToInt

/**
 *   Project: MyMovies
 *
 *   Package: softing.ubah4ukdev.mymovies.ui.movies.adapter
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
class MovieViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val viewBinding: MovieItemBinding by viewBinding()

    fun bind(
        movie: MoviesResponse.Movie,
        delegate: MovieAdapter.Delegate?,
        position: Int,
        countItems: Int
    ) {
        with(viewBinding) {
            title.text = movie.title

            val popular = (movie.voteAverage * MULTIPLIER).roundToInt()
            ratingProgress.setProgress(popular, true)
            ratingValue.text = popular.toString()
            ratingProgress.setIndicatorColor(getColorByValue(popular))

            toDateString(movie.releaseDate)?.let {
                release.text = it
            }

            Glide.with(poster)
                .load(BuildConfig.MOVIE_POSTER_PATH.plus(movie.posterPath))
                .apply(RequestOptions.bitmapTransform(RoundedCorners(IMAGE_RADIUS)))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .error(R.drawable.ic_no_image)
                .into(poster)

            viewBinding.root.click { delegate?.onItemClick(movie) }

            if (countItems > ZERO_VALUE && position == countItems - FIVE_VALUE) {
                delegate?.getMoreMovies()
            }
        }
    }

    companion object {
        private const val MULTIPLIER = 10
        private const val IMAGE_RADIUS = 18
        private const val ZERO_VALUE = 0
        private const val FIVE_VALUE = 5
    }
}