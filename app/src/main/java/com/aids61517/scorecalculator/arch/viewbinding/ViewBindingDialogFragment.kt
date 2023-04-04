package com.aids61517.scorecalculator.arch.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

abstract class ViewBindingDialogFragment<T : ViewBinding> : DialogFragment() {

    protected val binding: T
        get() = _binding ?: throw ViewBindingNotAvailableException(
            "View binding is only available between onCreateView() and onDestroyView()."
        )
    private var _binding: T? = null

    abstract fun onCreateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = onCreateViewBinding(inflater, container, savedInstanceState).let {
        _binding = it
        it.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}