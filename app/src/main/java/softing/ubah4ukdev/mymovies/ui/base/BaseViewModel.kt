package softing.ubah4ukdev.mymovies.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

/**
 *   Project: MyMovies
 *
 *   Package: softing.ubah4ukdev.mymovies.ui.base
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
abstract class BaseViewModel : ViewModel() {
    protected val viewModelScopeCoroutine = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        }
    )

    abstract fun handleError(throwable: Throwable)

    override fun onCleared() {
        super.onCleared()
        viewModelScopeCoroutine
            .coroutineContext
            .cancel()
    }
}