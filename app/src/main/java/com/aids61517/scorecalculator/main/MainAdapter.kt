package com.aids61517.scorecalculator.main

import android.view.ViewGroup
import com.aids61517.scorecalculator.arch.recyclerview.BaseRecyclerViewAdapter
import com.aids61517.scorecalculator.arch.recyclerview.Diffable
import com.aids61517.scorecalculator.arch.recyclerview.RecyclerViewItemAdapter
import com.aids61517.scorecalculator.main.viewholder.CopyViewHolder

class MainAdapter : BaseRecyclerViewAdapter<MainAdapter.CopyItem>() {
    data class CopyItem(
        val text: String,
        val isFavorite: Boolean,
        val onTextClicked: (String) -> Unit,
        val onFavoriteClicked: (String, Boolean) -> Unit,
    ) : Diffable<CopyItem> {
        override fun isItemTheSameAs(item: CopyItem): Boolean {
            return text == item.text
        }

        override fun isContentTheSameAs(item: CopyItem): Boolean {
            return isFavorite == item.isFavorite
        }
    }

    override fun onRegisterItemAdapter() {
        registerItemAdapter(CopyItem::class, copyItemAdapter)
    }

    private val copyItemAdapter = object : RecyclerViewItemAdapter<CopyItem, CopyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup): CopyViewHolder {
            return CopyViewHolder.create(parent)
        }

        override fun onBindViewHolder(item: CopyItem, viewHolder: CopyViewHolder) {
            viewHolder.bind(
                text = item.text,
                isFavorite = item.isFavorite,
                onTextClicked = item.onTextClicked,
                onFavoriteClicked = item.onFavoriteClicked,
            )
        }
    }
}