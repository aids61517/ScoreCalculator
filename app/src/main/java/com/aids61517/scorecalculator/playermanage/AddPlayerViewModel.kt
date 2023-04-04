package com.aids61517.scorecalculator.playermanage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aids61517.scorecalculator.arch.livedata.SingleLiveEvent
import com.aids61517.scorecalculator.model.Player
import com.aids61517.scorecalculator.repository.PlayerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AddPlayerViewModel(
    private val playerRepository: PlayerRepository,
) : ViewModel() {

    val addPlayerSuccessEvent = SingleLiveEvent<Player>()

    fun addPlayer(player: String) {
        viewModelScope.launch {
            val player = withContext(Dispatchers.IO) {
                playerRepository.addPlayer(player)
            }

            addPlayerSuccessEvent.value = player
        }
    }
}