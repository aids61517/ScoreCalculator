package com.aids61517.scorecalculator.arch.recyclerview

import androidx.recyclerview.widget.DiffUtil

/**
 * Make objects available for [DiffUtil] to diff.
 */
interface Diffable<in T> {

    companion object {
        fun <T : Diffable<T>> calculateDiff(
            oldItems: List<T>?,
            newItems: List<T>?,
            detectMoves: Boolean = true,
        ) = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

            override fun getOldListSize(): Int = oldItems?.size ?: 0

            override fun getNewListSize(): Int = newItems?.size ?: 0

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldItem = oldItems!![oldItemPosition]
                val newItem = newItems!![newItemPosition]
                return oldItem.isItemTheSameAs(newItem)
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldItem = oldItems!![oldItemPosition]
                val newItem = newItems!![newItemPosition]
                return oldItem.isContentTheSameAs(newItem)
            }

            override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
                val oldItem = oldItems!![oldItemPosition]
                val newItem = newItems!![newItemPosition]
                return oldItem.getChangePayloadWith(newItem)
            }
        }, detectMoves)
    }

    fun isItemTheSameAs(item: T): Boolean
    fun isContentTheSameAs(item: T): Boolean
    fun getChangePayloadWith(item: T): Any? = null
}