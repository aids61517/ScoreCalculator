package com.aids61517.scorecalculator.arch.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KClass

abstract class BaseRecyclerViewAdapter<I : Diffable<I>> :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<I> = emptyList()
        set(newItems) {
            val oldItems = field
            field = newItems
            Diffable.calculateDiff(oldItems, newItems, detectMoves).dispatchUpdatesTo(this)
            hasLoadMoreTriggered = false
        }

    private var loadMoreListener: (() -> Unit)? = null

    protected open val detectMoves
        get() = true

    private val registerAdapterItem =
        mutableMapOf<KClass<*>, RecyclerViewPayloadItemAdapter<I, RecyclerView.ViewHolder, Any>>()

    private var hasLoadMoreTriggered = false

    private var loadMoreThreshold = 0

    override fun getItemViewType(position: Int): Int {
        if (registerAdapterItem.isEmpty()) {
            onRegisterItemAdapter()
        }

        return registerAdapterItem.keys
            .indexOfFirst { items[position]::class == it }
            .takeIf { it != -1 } ?: error("Unregister item ${items[position]}")
    }

    abstract fun onRegisterItemAdapter()

    protected fun <Item : I, VH : RecyclerView.ViewHolder, Payload> registerItemAdapter(
        itemClass: KClass<Item>,
        adapterItem: RecyclerViewPayloadItemAdapter<Item, VH, Payload>,
    ) {
        registerAdapterItem[itemClass] =
            adapterItem as RecyclerViewPayloadItemAdapter<I, RecyclerView.ViewHolder, Any>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val kClass = registerAdapterItem.keys.toList()[viewType]
        return registerAdapterItem.getValue(kClass)
            .onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = items[position]
        val adapterItem = registerAdapterItem[data::class]
        adapterItem!!.onBindViewHolder(data, holder)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (shouldLoadMoreTrigger(position)) {
            hasLoadMoreTriggered = true
            loadMoreListener?.invoke()
        }

        val payload = payloads.firstOrNull()
        val data = items[position]
        val adapterItem = registerAdapterItem[data::class]
        if (payload != null) {
            adapterItem!!.onBindViewHolder(data, holder, payload)
        } else {
            onBindViewHolder(holder, position)
        }
    }

    private fun shouldLoadMoreTrigger(position: Int): Boolean {
        return loadMoreListener != null && hasLoadMoreTriggered.not() &&
            position >= items.lastIndex - loadMoreThreshold
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setOnLoadMoreListener(threshold: Int, loadMoreListener: (() -> Unit)?) {
        this.loadMoreThreshold = threshold
        this.loadMoreListener = loadMoreListener
    }
}

abstract class RecyclerViewPayloadItemAdapter<Item : Any, VH : RecyclerView.ViewHolder, Payload> {

    abstract fun onCreateViewHolder(parent: ViewGroup): VH

    abstract fun onBindViewHolder(item: Item, viewHolder: VH)

    abstract fun onBindViewHolder(item: Item, viewHolder: VH, payload: Payload)
}

abstract class RecyclerViewItemAdapter<Item : Any, VH : RecyclerView.ViewHolder> :
    RecyclerViewPayloadItemAdapter<Item, VH, Nothing>() {

    override fun onBindViewHolder(item: Item, viewHolder: VH, payload: Nothing) {
        // No handling required
    }
}