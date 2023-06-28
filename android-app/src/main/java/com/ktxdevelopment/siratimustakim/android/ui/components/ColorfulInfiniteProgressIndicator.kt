package com.ktxdevelopment.siratimustakim.android.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt


@Composable
fun ColorfulInfiniteProgressIndicator(isDisplayed: Boolean, verticalBias: Float) {

    val animatedColor by animateColorAsState(getProgressColor())

    if (isDisplayed) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(constraints)
                    val yPos = constraints.maxHeight * verticalBias - placeable.height / 2
                    layout(placeable.width, placeable.height) {
                        placeable.placeRelative(0, yPos.roundToInt())
                    }
                }
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(48.dp)
                    .padding(16.dp),
                color = getProgressColor()
            )
        }
    }
}

@Composable
fun getProgressColor(): Color {
    val color by animateColorAsState(Color.Red)
    return color
}
