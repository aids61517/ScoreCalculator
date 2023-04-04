package com.aids61517.scorecalculator.arch.fragmentresult

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.aids61517.scorecalculator.arch.fragmentresult.binding.FragmentResultFragmentBinding
import com.aids61517.scorecalculator.arch.fragmentresult.launcher.DialogFragmentLauncher
import com.aids61517.scorecalculator.arch.fragmentresult.launcher.FragmentLauncher

interface FragmentResult {
    fun <Interaction> registerDialogFragment(
        activity: FragmentActivity,
        interaction: (() -> Interaction)?,
    ): DialogFragmentLauncher

    fun <Interaction> registerDialogFragment(
        fragment: Fragment,
        interaction: (() -> Interaction)?,
    ): DialogFragmentLauncher

    fun registerFragment(
        activity: FragmentActivity
    ): FragmentLauncher

    fun registerFragment(fragment: Fragment): FragmentLauncher

    fun <Interaction> registerFragment(
        activity: FragmentActivity,
        interaction: (() -> Interaction)?,
    ): FragmentLauncher

    fun <Interaction> registerFragment(
        fragment: Fragment,
        interaction: (() -> Interaction)?,
    ): FragmentLauncher

    fun <Interaction> registerFragmentBinding(activity: FragmentActivity): FragmentResultFragmentBinding<Interaction>

    fun <Interaction> registerFragmentBinding(fragment: Fragment): FragmentResultFragmentBinding<Interaction>

    fun findRegisterInteraction(fragmentTag: String): Any?
}