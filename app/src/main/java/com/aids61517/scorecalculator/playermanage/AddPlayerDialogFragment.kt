package com.aids61517.scorecalculator.playermanage

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.aids61517.scorecalculator.arch.delegation.getInteractionFromParent
import com.aids61517.scorecalculator.arch.viewbinding.ViewBindingDialogFragment
import com.aids61517.scorecalculator.databinding.AddPlayerDialogFragmentBinding
import com.aids61517.scorecalculator.model.Player
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.properties.Delegates

class AddPlayerDialogFragment : ViewBindingDialogFragment<AddPlayerDialogFragmentBinding>() {

    interface Interaction {
        fun onPlayerAdded(player: Player)

        fun onPlayerCanceled()
    }

    private val viewModel by viewModel<AddPlayerViewModel>()

    private val interaction by Delegates.getInteractionFromParent<Interaction>()

    init {
        isCancelable = false
    }

    override fun onCreateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = AddPlayerDialogFragmentBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nameEditText.apply {
            doOnTextChanged { text, _, _, _ ->
                binding.addButton.isEnabled = text?.isNotEmpty() ?: false
            }
        }

        binding.addButton.apply {
            isEnabled = false

            setOnClickListener {
                viewModel.addPlayer(binding.nameEditText.text.toString())
            }
        }

        binding.cancelButton.setOnClickListener {
            interaction.onPlayerCanceled()
            dismiss()
        }

        viewModel.addPlayerSuccessEvent.observe(viewLifecycleOwner) {
            interaction.onPlayerAdded(it)
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.let { dialog ->
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
        }
    }
}