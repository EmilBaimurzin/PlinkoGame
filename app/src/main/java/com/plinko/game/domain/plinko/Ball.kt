package com.plinko.game.domain.plinko

import java.util.Random

data class Ball(
    val color: Boolean = Random().nextBoolean(),
    var position: Pair<Float,Float>,
    var isFlying: Boolean,
    var verticalLine: Int = 1,
    var horizontalPosition: Int
)
