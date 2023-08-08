package com.plinko.game.ui.dialogs

import android.app.Dialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.plinko.game.R
import com.plinko.game.core.library.ViewBindingDialog
import com.plinko.game.databinding.DialogFinalBinding
import com.plinko.game.ui.menu.FragmentMenuDirections

class DialogFinal: ViewBindingDialog<DialogFinalBinding>(DialogFinalBinding::inflate) {
    private val args: DialogFinalArgs by navArgs()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext(), R.style.Dialog_No_Border)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog!!.setCancelable(false)
        dialog!!.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                findNavController().popBackStack(R.id.fragmentMain, false, false)
                true
            } else {
                false
            }
        }

        binding.moves.text = args.moves.toString()
        binding.points.text = args.points.toString()

        binding.buttonNext.setOnClickListener {
            findNavController().popBackStack(R.id.fragmentMain, false, false)
            findNavController().navigate(FragmentMenuDirections.actionFragmentMainToFragmentPlinko(0, 0))
        }
    }
}