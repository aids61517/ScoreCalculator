package com.aids61517.scorecalculator.arch.fragmentresult.binding

import androidx.fragment.app.FragmentManager
import com.aids61517.scorecalculator.arch.fragmentresult.FragmentInteractionLazyBinding
import com.aids61517.scorecalculator.arch.fragmentresult.launcher.DialogFragmentLauncher
import com.aids61517.scorecalculator.arch.fragmentresult.launcher.FragmentLauncher

class FragmentResultFragmentBinding<Interaction>(
    override val fragmentTag: String,
    internal val getFragmentManager: () -> FragmentManager,
    private val fragmentInteractionLazyBinding: FragmentInteractionLazyBinding,
) : FragmentResultBinding {
    fun bindDialogActionInteraction(interaction: (() -> Interaction)?): DialogFragmentLauncher {
        return fragmentInteractionLazyBinding.bindDialogActionInteraction(this, interaction)
    }

    fun bindFragmentInteraction(interaction: (() -> Interaction)?): FragmentLauncher {
        return fragmentInteractionLazyBinding.bindFragmentInteraction(this, interaction)
    }
}