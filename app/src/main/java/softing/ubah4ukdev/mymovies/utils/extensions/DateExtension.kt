package softing.ubah4ukdev.mymovies.utils.extensions

import java.text.SimpleDateFormat
import java.util.*

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
fun toDateString(value: String): String? =
    SimpleDateFormat(DATE_FORMAT_IN, Locale.getDefault())
        .parse(value)?.let { date ->
            SimpleDateFormat(DATE_FORMAT_OUT, Locale.getDefault()).format(date)
        }

const val DATE_FORMAT_IN = "yyyy-MM-dd"
const val DATE_FORMAT_OUT = "dd MMMM yyyy"