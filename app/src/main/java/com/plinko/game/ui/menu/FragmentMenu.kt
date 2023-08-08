package com.plinko.game.ui.menu

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.plinko.game.R
import com.plinko.game.databinding.FragmentMenuBinding
import com.plinko.game.ui.other.ViewBindingFragment

class FragmentMenu : ViewBindingFragment<FragmentMenuBinding>(FragmentMenuBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.playButton.setOnClickListener {
            findNavController().navigate(FragmentMenuDirections.actionFragmentMainToFragmentPlinko(0, 0))
        }
        binding.exitButton.setOnClickListener {
            requireActivity().finish()
        }

        binding.privacyText.setOnClickListener {
            requireActivity().startActivity(
                Intent(
                    ACTION_VIEW,
                    Uri.parse("https://www.google.com")
                )
            )
        }
    }
}