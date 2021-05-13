package com.company.coreArchitecture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

abstract class BaseFragment<UM : UiModel, VM : BaseViewModel<UM>>(
    @LayoutRes val layoutRes: Int
) : Fragment() {

    protected abstract val viewModel: VM

    protected abstract fun initViews(view: View)
    protected abstract fun render(model: UM)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(layoutRes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)

        viewModel.run {
            uiLiveData.observe(viewLifecycleOwner, Observer { render(it) })
        }
    }
}