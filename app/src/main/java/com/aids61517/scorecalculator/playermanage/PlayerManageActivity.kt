package com.aids61517.scorecalculator.playermanage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.aids61517.scorecalculator.arch.fragmentresult.FragmentResult
import com.aids61517.scorecalculator.arch.fragmentresult.FragmentResultManager
import com.aids61517.scorecalculator.arch.viewbinding.ViewBindingActivity
import com.aids61517.scorecalculator.databinding.PlayerManageActivityBinding
import com.aids61517.scorecalculator.model.Player
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayerManageActivity : ViewBindingActivity<PlayerManageActivityBinding>(),
    FragmentResult by FragmentResultManager() {
    companion object {
        fun newIntent(context: Context): Intent = Intent(context, PlayerManageActivity::class.java)
    }

    private val addPlayerLauncher = registerDialogFragment(this) {
        object : AddPlayerDialogFragment.Interaction {
            override fun onPlayerAdded(player: Player) {
                viewModel.updatePlayers()
            }

            override fun onPlayerCanceled() {
            }
        }
    }

    private val viewModel by viewModel<PlayerManageViewModel>()

    override fun onCreateViewBinding(inflater: LayoutInflater) =
        PlayerManageActivityBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        setupViewModel()
        viewModel.initPlayer()
    }

    private fun setupView() {
        binding.fab.setOnClickListener {
            addPlayerLauncher.launch(AddPlayerDialogFragment())
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PlayerManageAdapter()
        }
    }

    private fun setupViewModel() {
        viewModel.playerList.observe(this) {
            (binding.recyclerView.adapter as PlayerManageAdapter).items = buildItems(it)
        }
    }

    private fun buildItems(playerList: List<Player>): List<PlayerManageAdapter.PlayerItem> {
        return playerList.map { PlayerManageAdapter.PlayerItem(it) }
    }
}