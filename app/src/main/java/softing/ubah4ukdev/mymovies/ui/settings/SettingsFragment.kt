package softing.ubah4ukdev.mymovies.ui.settings

import org.koin.androidx.viewmodel.ext.android.viewModel
import softing.ubah4ukdev.mymovies.R
import softing.ubah4ukdev.mymovies.databinding.FragmentSettingsBinding
import softing.ubah4ukdev.mymovies.domain.AppState
import softing.ubah4ukdev.mymovies.ui.base.BaseFragment
import softing.ubah4ukdev.mymovies.utils.extensions.showSnakeBar

class SettingsFragment : BaseFragment<FragmentSettingsBinding>(R.layout.fragment_settings) {

    val viewModel: SettingsViewModel by viewModel()

    override fun initListeners() {}
    override fun initObservers() {}
    override fun renderSuccess(result: AppState.Success<*>) {}

    override fun showLoading(isShow: Boolean) {}

    override fun showError(throwable: Throwable) {
        viewBinding.root.showSnakeBar(throwable.localizedMessage)
    }

}