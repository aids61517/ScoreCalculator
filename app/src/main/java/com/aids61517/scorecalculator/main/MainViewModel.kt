package com.aids61517.scorecalculator.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aids61517.scorecalculator.repository.PlayerRepository
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MainViewModel(
    private val playerRepository: PlayerRepository,
) : ViewModel() {

    val isNewGameEnabled = MutableLiveData<Boolean>()

    init {
        viewModelScope.launch {
            playerRepository.observeAllPlayer()
                .collect {
                    isNewGameEnabled.value = it.isNotEmpty()
                }
        }
    }
}