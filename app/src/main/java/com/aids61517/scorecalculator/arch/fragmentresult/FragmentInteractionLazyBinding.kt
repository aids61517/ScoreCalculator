package com.aids61517.scorecalculator.arch.fragmentresult

import com.aids61517.scorecalculator.arch.fragmentresult.binding.FragmentResultFragmentBinding
import com.aids61517.scorecalculator.arch.fragmentresult.launcher.DialogFragmentLauncher
import com.aids61517.scorecalculator.arch.fragmentresult.launcher.FragmentLauncher

interface FragmentInteractionLazyBinding {
    fun <Interaction> bindDialogActionInteraction(
        fragmentResultBinding: FragmentResultFragmentBinding<Interaction>,
        interaction: (() -> Interaction)?,
    ): DialogFragmentLauncher

    fun <Interaction> bindFragmentInteraction(
        fragmentResultBinding: FragmentResultFragmentBinding<Interaction>,
        interaction: (() -> Interaction)?,
    ): FragmentLauncher
}