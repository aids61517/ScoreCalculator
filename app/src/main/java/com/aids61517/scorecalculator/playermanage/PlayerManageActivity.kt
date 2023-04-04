package com.aids61517.scorecalculator.playermanage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.aids61517.scorecalculator.arch.fragmentresult.FragmentResult
import com.aids61517.scorecalculator.arch.fragmentresult.FragmentResultManager
import com.aids61517.scorecalculator.arch.viewbinding.ViewBindingActivity
import com.aids61517.scorecalculator.databinding.PlayerManageActivityBinding
import com.aids61517.scorecalculator.model.Player

class PlayerManageActivity : ViewBindingActivity<PlayerManageActivityBinding>(),
    FragmentResult by FragmentResultManager() {
    companion object {
        fun newIntent(context: Context): Intent = Intent(context, PlayerManageActivity::class.java)
    }

    private val addPlayerLauncher = registerDialogFragment(this) {
        object : AddPlayerDialogFragment.Interaction {
            override fun onPlayerAdded(player: Player) {
                val a = 1
            }

            override fun onPlayerCanceled() {

            }
        }
    }

    override fun onCreateViewBinding(inflater: LayoutInflater) =
        PlayerManageActivityBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
    }

    private fun setupView() {
        binding.fab.setOnClickListener {
            addPlayerLauncher.launch(AddPlayerDialogFragment())
        }
    }
}