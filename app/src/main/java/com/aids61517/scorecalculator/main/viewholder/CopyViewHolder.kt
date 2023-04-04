package com.aids61517.scorecalculator.main.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aids61517.scorecalculator.R
import com.aids61517.scorecalculator.databinding.CopyItemBinding

class CopyViewHolder(
    private val binding: CopyItemBinding,
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(parent: ViewGroup): CopyViewHolder {
            return CopyViewHolder(
                CopyItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false,
                )
            )
        }
    }

    fun bind(
        text: String,
        isFavorite: Boolean,
        onTextClicked: (String) -> Unit,
        onFavoriteClicked: (String, Boolean) -> Unit,
    ) {
        binding.textView.apply {
            this.text = text
            setOnClickListener {
                onTextClicked(text)
            }
        }

        binding.favoriteButton.apply {
            val drawableId = if (isFavorite) {
                R.drawable.star_24
            } else {
                R.drawable.star_border_24
            }
            setImageResource(drawableId)
            setOnClickListener {
                onFavoriteClicked(text, isFavorite)
            }
        }
    }
}