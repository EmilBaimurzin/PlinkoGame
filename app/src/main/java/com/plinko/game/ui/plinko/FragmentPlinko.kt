package com.plinko.game.ui.plinko

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.plinko.game.R
import com.plinko.game.databinding.FragmentPlinkoBinding
import com.plinko.game.ui.menu.FragmentMenuDirections
import com.plinko.game.ui.other.ViewBindingFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class FragmentPlinko : ViewBindingFragment<FragmentPlinkoBinding>(FragmentPlinkoBinding::inflate) {
    private val viewModel: PlinkoViewModel by viewModels()
    private val args: FragmentPlinkoArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(20)
            viewModel.initCannon(binding.game.x + dpToPx(15), binding.game.y)
            if (viewModel.gameState) {
                viewModel.start(
                    binding.cannon.width,
                    binding.game.x + binding.game.width - dpToPx(15),
                    binding.game.x + dpToPx(15),
                    topLimit = (binding.game.y + dpToPx(210)).toInt(),
                    longLineStartedDotPosition = binding.game.x.toInt() + dpToPx(28),
                    shortLineStartedDotPosition = binding.game.x.toInt() + dpToPx(48),
                    horizontalDistanceBetweenDots = dpToPx(35),
                    verticaDistanceBetweenDots = dpToPx(30),
                    ballSize = dpToPx(25),
                )
            }
        }

        binding.buttonHome.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.buttonRestart.setOnClickListener {
            findNavController().popBackStack()
            findNavController().navigate(FragmentMenuDirections.actionFragmentMainToFragmentPlinko(0,0))
        }

        if (args.moves != 0) {
            viewModel.goalScores = args.points
            viewModel.goalMoves = args.moves
        }

        binding.movesTask.text = viewModel.goalMoves.toString()
        binding.pointsTask.text = viewModel.goalScores.toString()

        viewModel.checkWinCallback = {
            lifecycleScope.launch(Dispatchers.Main) {
                viewModel.stop()
                viewModel.gameState = false
                if (viewModel.scores >= viewModel.goalScores) {
                    findNavController().navigate(
                        FragmentPlinkoDirections.actionFragmentPlinkoToDialogFinal(
                            viewModel.goalScores,
                            viewModel.goalMoves
                        )
                    )
                } else {
                    findNavController().navigate(
                        FragmentPlinkoDirections.actionFragmentPlinkoToDialogFinalLose(
                            viewModel.scores,
                            viewModel.goalMoves,
                            viewModel.goalScores
                        )
                    )
                }
            }
        }

        viewModel.containers.observe(viewLifecycleOwner) {
            binding.apply {
                listOf(
                    container1,
                    container2,
                    container3,
                    container4,
                    container5,
                    container6,
                    container7,
                    container8,
                ).forEach {
                    it.removeAllViews()
                }
                it.forEach { container ->
                    when (container.key) {
                        1 -> {
                            container.value.forEachIndexed { index, value ->
                                if (index < 3) {
                                    val ballView = ImageView(requireContext())
                                    ballView.layoutParams =
                                        ViewGroup.LayoutParams(dpToPx(25), dpToPx(25))
                                    ballView.setImageResource(if (value) R.drawable.ball01 else R.drawable.ball02)
                                    binding.container1.addView(ballView)
                                }
                            }
                        }

                        2 -> {
                            container.value.forEachIndexed { index, value ->
                                if (index < 3) {
                                    val ballView = ImageView(requireContext())
                                    ballView.layoutParams =
                                        ViewGroup.LayoutParams(dpToPx(25), dpToPx(25))
                                    ballView.setImageResource(if (value) R.drawable.ball01 else R.drawable.ball02)
                                    binding.container2.addView(ballView)
                                }
                            }
                        }

                        3 -> {
                            container.value.forEachIndexed { index, value ->
                                if (index < 3) {
                                    val ballView = ImageView(requireContext())
                                    ballView.layoutParams =
                                        ViewGroup.LayoutParams(dpToPx(25), dpToPx(25))
                                    ballView.setImageResource(if (value) R.drawable.ball01 else R.drawable.ball02)
                                    binding.container3.addView(ballView)
                                }
                            }
                        }

                        4 -> {
                            container.value.forEachIndexed { index, value ->
                                if (index < 3) {
                                    val ballView = ImageView(requireContext())
                                    ballView.layoutParams =
                                        ViewGroup.LayoutParams(dpToPx(25), dpToPx(25))
                                    ballView.setImageResource(if (value) R.drawable.ball01 else R.drawable.ball02)
                                    binding.container4.addView(ballView)
                                }
                            }
                        }

                        5 -> {
                            container.value.forEachIndexed { index, value ->
                                if (index < 3) {
                                    val ballView = ImageView(requireContext())
                                    ballView.layoutParams =
                                        ViewGroup.LayoutParams(dpToPx(25), dpToPx(25))
                                    ballView.setImageResource(if (value) R.drawable.ball01 else R.drawable.ball02)
                                    binding.container5.addView(ballView)
                                }
                            }
                        }

                        6 -> {
                            container.value.forEachIndexed { index, value ->
                                if (index < 3) {
                                    val ballView = ImageView(requireContext())
                                    ballView.layoutParams =
                                        ViewGroup.LayoutParams(dpToPx(25), dpToPx(25))
                                    ballView.setImageResource(if (value) R.drawable.ball01 else R.drawable.ball02)
                                    binding.container6.addView(ballView)
                                }
                            }
                        }

                        7 -> {
                            container.value.forEachIndexed { index, value ->
                                if (index < 3) {
                                    val ballView = ImageView(requireContext())
                                    ballView.layoutParams =
                                        ViewGroup.LayoutParams(dpToPx(25), dpToPx(25))
                                    ballView.setImageResource(if (value) R.drawable.ball01 else R.drawable.ball02)
                                    binding.container7.addView(ballView)
                                }
                            }
                        }

                        else -> {
                            container.value.forEachIndexed { index, value ->
                                if (index < 3) {
                                    val ballView = ImageView(requireContext())
                                    ballView.layoutParams =
                                        ViewGroup.LayoutParams(dpToPx(25), dpToPx(25))
                                    ballView.setImageResource(if (value) R.drawable.ball01 else R.drawable.ball02)
                                    binding.container8.addView(ballView)
                                }
                            }
                        }
                    }
                }
            }
        }

        binding.buttonThrow.setOnClickListener {
            viewModel.spawnBall(binding.cannon.height, dpToPx(8))
        }

        viewModel.cannonPosition.observe(viewLifecycleOwner) {
            binding.cannon.apply {
                x = it.first
                y = it.second
            }
        }

        viewModel.balls.observe(viewLifecycleOwner) {
            binding.ballsLayout.removeAllViews()
            it.forEach { ball ->
                val ballView = ImageView(requireContext())
                ballView.layoutParams = ViewGroup.LayoutParams(dpToPx(25), dpToPx(25))
                ballView.setImageResource(if (ball.color) R.drawable.ball01 else R.drawable.ball02)
                ballView.x = ball.position.first - dpToPx(10)
                ballView.y = ball.position.second
                binding.ballsLayout.addView(ballView)
            }
        }
    }

    private fun dpToPx(dp: Int): Int {
        val displayMetrics = resources.displayMetrics
        return (dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
    }

    override fun onPause() {
        super.onPause()
        viewModel.stop()
    }
}