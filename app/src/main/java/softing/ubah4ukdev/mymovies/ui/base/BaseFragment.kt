package softing.ubah4ukdev.mymovies.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import softing.ubah4ukdev.mymovies.domain.IAppState
import java.lang.reflect.ParameterizedType

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
 *   2022.02.20
 *
 *   v1.0
 */
abstract class BaseFragment<VB : ViewBinding>(
    @LayoutRes contentLayoutId: Int
) : Fragment(contentLayoutId) {
    private var binding: VB? = null
    protected val viewBinding: VB get() = binding!!

    /**
     * Инициализация слушателей
     */
    abstract fun initListeners()

    /**
     * Инициализация подписок
     */
    abstract fun initObservers()
    abstract fun renderData(result: IAppState)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VB>)
            .getMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.java
            ).also {
                binding = it.invoke(null, layoutInflater, container, false) as VB
            }

        initObservers()
        initListeners()
        return viewBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}