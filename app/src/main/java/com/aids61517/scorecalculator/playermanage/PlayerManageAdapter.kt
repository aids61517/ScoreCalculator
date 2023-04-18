package com.aids61517.scorecalculator.playermanage

import android.view.ViewGroup
import com.aids61517.scorecalculator.arch.recyclerview.BaseRecyclerViewAdapter
import com.aids61517.scorecalculator.arch.recyclerview.Diffable
import com.aids61517.scorecalculator.arch.recyclerview.RecyclerViewItemAdapter
import com.aids61517.scorecalculator.model.Player
import com.aids61517.scorecalculator.playermanage.viewholder.PlayerViewHolder

class PlayerManageAdapter : BaseRecyclerViewAdapter<PlayerManageAdapter.PlayerItem>() {

    data class PlayerItem(
        val player: Player,
    ) : Diffable<PlayerItem> {
        override fun isItemTheSameAs(item: PlayerItem): Boolean {
            return player.id == item.player.id
        }

        override fun isContentTheSameAs(item: PlayerItem): Boolean {
            return player == item.player
        }
    }

    override fun onRegisterItemAdapter() {
        registerItemAdapter(PlayerItem::class, playerItemAdapter)
    }

    private val playerItemAdapter =
        object : RecyclerViewItemAdapter<PlayerItem, PlayerViewHolder>() {

            override fun onCreateViewHolder(parent: ViewGroup): PlayerViewHolder {
                return PlayerViewHolder.create(parent)
            }

            override fun onBindViewHolder(item: PlayerItem, viewHolder: PlayerViewHolder) {
                viewHolder.bind(item.player)
            }
        }
}