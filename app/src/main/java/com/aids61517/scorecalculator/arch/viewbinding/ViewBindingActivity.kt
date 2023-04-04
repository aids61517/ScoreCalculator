package com.aids61517.scorecalculator.arch.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

abstract class ViewBindingActivity<T : ViewBinding> : FragmentActivity() {

    protected val binding: T
        get() = _binding ?: throw ViewBindingNotAvailableException(
            "View binding is only available after onCreate()."
        )
    private var _binding: T? = null

    abstract fun onCreateViewBinding(inflater: LayoutInflater): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateViewBinding(layoutInflater).also {
            _binding = it
            setContentView(it.root)
        }
    }
}