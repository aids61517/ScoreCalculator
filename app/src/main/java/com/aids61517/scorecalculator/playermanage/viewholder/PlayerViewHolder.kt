package com.aids61517.scorecalculator.playermanage.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aids61517.scorecalculator.databinding.PlayerManageItemBinding
import com.aids61517.scorecalculator.model.Player

class PlayerViewHolder(
    private val binding: PlayerManageItemBinding,
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(parent: ViewGroup): PlayerViewHolder {
            return PlayerViewHolder(
                PlayerManageItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    fun bind(player: Player) {
        binding.playerName.text = player.name
    }
}