package softing.ubah4ukdev.mymovies.utils.extensions

import android.graphics.Color


/**
 *   Project: MyMovies
 *
 *   Package: softing.ubah4ukdev.mymovies.utils.extensions
 *
 *   Created by Ivan Sheynmaer
 *
 *   Description:
 *
 *
 *   2022.02.23
 *
 *   v1.0
 */
fun getColorByValue(value: Int): Int =
    when (value) {
        in 0..25 -> Color.parseColor("#FF0000")
        in 26..50 -> Color.parseColor("#FF8C00")
        in 51..75 -> Color.parseColor("#FFFF00")
        else -> Color.parseColor("#00FF00")
    }