package com.aids61517.scorecalculator.arch.fragmentresult.launcher

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

class DialogFragmentLauncher(
    val fragmentTag: String,
    private val getFragmentManager: () -> FragmentManager,
) {
    fun launch(dialogFragment: DialogFragment) {
        dialogFragment.show(getFragmentManager(), fragmentTag)
    }
}

fun DialogFragment.launchBy(launcher: DialogFragmentLauncher) {
    launcher.launch(this)
}