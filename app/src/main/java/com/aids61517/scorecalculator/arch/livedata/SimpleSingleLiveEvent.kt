package com.aids61517.scorecalculator.arch.livedata

import androidx.annotation.MainThread

/**
 * [Unit] version of [SingleLiveEvent].
 */
class SimpleSingleLiveEvent : SingleLiveEvent<Unit?>() {

    @MainThread
    fun call() {
        value = Unit
    }

    fun postCall() {
        postValue(Unit)
    }
}
