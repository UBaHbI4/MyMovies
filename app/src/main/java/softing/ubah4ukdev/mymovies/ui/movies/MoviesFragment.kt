package softing.ubah4ukdev.mymovies.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import softing.ubah4ukdev.mymovies.R
import softing.ubah4ukdev.mymovies.databinding.FragmentMoviesBinding
import softing.ubah4ukdev.mymovies.ui.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import softing.ubah4ukdev.mymovies.domain.IAppState

class MoviesFragment() : BaseFragment<FragmentMoviesBinding>(R.layout.fragment_movies) {

    val viewModel: MoviesViewModel by viewModel()

    override fun initListeners() {}
    override fun initObservers() {}
    override fun renderData(result: IAppState) {}
}