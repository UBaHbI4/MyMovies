package softing.ubah4ukdev.mymovies.ui.detail

import org.koin.androidx.viewmodel.ext.android.viewModel
import softing.ubah4ukdev.mymovies.R
import softing.ubah4ukdev.mymovies.databinding.FragmentDetailBinding
import softing.ubah4ukdev.mymovies.domain.IAppState
import softing.ubah4ukdev.mymovies.ui.base.BaseFragment
import softing.ubah4ukdev.mymovies.ui.movies.MoviesViewModel

class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    val viewModel: DetailViewModel by viewModel()

    override fun initListeners() {}
    override fun initObservers() {}
    override fun renderData(result: IAppState) {}
}