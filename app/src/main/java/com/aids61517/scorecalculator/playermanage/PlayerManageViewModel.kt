package com.aids61517.scorecalculator.playermanage

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aids61517.scorecalculator.model.Player
import com.aids61517.scorecalculator.repository.PlayerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class PlayerManageViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val playerRepository: PlayerRepository,
) : ViewModel() {
    companion object {
        private const val EXTRA_PLAYER_LIST = "EXTRA_PLAYER_LIST"
    }

    val playerList = savedStateHandle.getLiveData<List<Player>>(EXTRA_PLAYER_LIST)

    fun initPlayer() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                playerRepository.getPlayer()
            }.let {
                playerList.value = it
            }
        }
    }

    fun updatePlayers() {
        initPlayer()
    }
}