package com.aids61517.scorecalculator.newgame

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.aids61517.scorecalculator.arch.viewbinding.ViewBindingActivity
import com.aids61517.scorecalculator.databinding.NewGameActivityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewGameActivity : ViewBindingActivity<NewGameActivityBinding>() {
    companion object {
        fun newIntent(context: Context): Intent = Intent(context, NewGameActivity::class.java)
    }

    private val viewModel by viewModel<NewGameViewModel>()

    override fun onCreateViewBinding(inflater: LayoutInflater) =
        NewGameActivityBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.basicPrice.observe(this) {
            binding.basicPriceEditText.apply {
                val priceString = it.toString()
                if (text.toString() != priceString) {
                    setText(priceString)
                }
            }
        }
    }
}