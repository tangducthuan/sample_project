package com.itat.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Thuan on 14/2/25
 */
abstract class BaseBindingActivity<BINDING : ViewDataBinding> : AppCompatActivity() {

    private lateinit var _binding: BINDING
    protected val binding: BINDING
        get() = _binding

    abstract val layoutResId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutResId, null, false)

        configBinding()

        setContentView(_binding.root)

        observe()
    }

    /**
     * Config views, set view's event. Call before view is set to Activity
     */
    abstract fun configBinding()

    /**
     * Observe UIState, UIEvent. Call after view is set to Activity
     */
    abstract fun observe()
}