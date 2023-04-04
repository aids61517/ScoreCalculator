package com.aids61517.scorecalculator.main

import android.app.Application
import android.content.ClipboardManager
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aids61517.scorecalculator.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MainViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {

    val isNewGameEnabled = MutableLiveData<Boolean>()

    init {
        viewModelScope.launch {
            userRepository.observeAllUser()
                .collect {
                    isNewGameEnabled.value = it.isNotEmpty()
                }
        }
    }
}