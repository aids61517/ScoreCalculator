package com.aids61517.scorecalculator.newgame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class NewGameViewModel : ViewModel() {
    companion object {
        private const val DEFAULT_BASIC_PRICE = 30
        private const val DEFAULT_EXTRA_POINT_PRICE = 10
    }

    val basicPrice = MutableLiveData(DEFAULT_BASIC_PRICE)

    val extraPointPrice = MutableLiveData(DEFAULT_EXTRA_POINT_PRICE)


}