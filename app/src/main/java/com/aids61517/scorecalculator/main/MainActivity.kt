package com.aids61517.scorecalculator.main

import android.os.Bundle
import android.view.LayoutInflater
import com.aids61517.scorecalculator.arch.viewbinding.ViewBindingActivity
import com.aids61517.scorecalculator.databinding.MainActivityBinding
import com.aids61517.scorecalculator.newgame.NewGameActivity
import com.aids61517.scorecalculator.playermanage.PlayerManageActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ViewBindingActivity<MainActivityBinding>() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateViewBinding(inflater: LayoutInflater) =
        MainActivityBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        setupViewModel()
    }

    private fun setupView() {
        binding.newGameButton.setOnClickListener {
            startActivity(NewGameActivity.newIntent(this))
        }

        binding.playerManageButton.setOnClickListener {
            startActivity(PlayerManageActivity.newIntent(this))
        }
    }

    private fun setupViewModel() {
        viewModel.isNewGameEnabled.observe(this) {
            binding.newGameButton.isEnabled = it
        }
    }
}