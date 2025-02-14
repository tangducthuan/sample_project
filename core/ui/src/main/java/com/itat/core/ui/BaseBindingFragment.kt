package com.itat.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Created by Thuan on 14/2/25
 */
abstract class BaseBindingFragment<BINDING : ViewDataBinding> : Fragment() {

    private var _binding: BINDING? = null
    protected val binding: BINDING
        get() = _binding!!

    abstract val layoutResId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)

        configBinding()

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Config views, set view's event. Call before view is set to Fragment
     */
    abstract fun configBinding()

    /**
     * Observe UIState, UIEvent. Call after view is set to Fragment
     */
    abstract fun observe()
}