package com.aids61517.scorecalculator.main

import android.os.Bundle
import android.view.LayoutInflater
import com.aids61517.scorecalculator.databinding.MainActivityBinding
import com.aids61517.scorecalculator.arch.viewbinding.ViewBindingActivity
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
//        binding.recyclerView.apply {
//            adapter = MainAdapter()
//            layoutManager = LinearLayoutManager(this@MainActivity)
//        }
        binding.newGameButton.setOnClickListener {

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

//    private fun buildItem(copyItemList: List<MainViewModel.CopyItem>): List<MainAdapter.CopyItem> {
//        return copyItemList.map {
//            MainAdapter.CopyItem(
//                text = it.text,
//                isFavorite = it.isFavorite,
//                onTextClicked = onTextClickedListener,
//                onFavoriteClicked = onFavoriteClickedListener,
//            )
//        }
//    }
//
//    private val onTextClickedListener: (String) -> Unit = { text ->
//        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//        clipboardManager.setPrimaryClip(ClipData.newPlainText("", text))
//        Toast.makeText(this, R.string.text_copied, Toast.LENGTH_SHORT)
//            .show()
//        viewModel.onTextClicked(text)
//    }
//
//    private val onFavoriteClickedListener: (String, Boolean) -> Unit = { text, isFavorite ->
//        viewModel.onFavoriteClicked(text, isFavorite)
//    }
//
//    override fun onWindowFocusChanged(hasFocus: Boolean) {
//        super.onWindowFocusChanged(hasFocus)
//        if (hasFocus) {
//            lifecycleScope.launch {
//                delay(1000)
//                viewModel.updateItem()
//            }
//        }
//    }
}