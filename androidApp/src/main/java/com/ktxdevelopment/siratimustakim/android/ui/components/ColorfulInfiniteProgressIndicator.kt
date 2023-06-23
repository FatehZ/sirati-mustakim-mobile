package com.ktxdevelopment.siratimustakim.android.ui.components


@Composable
fun ColorfulInfiniteProgressIndicator(isDisplayed: Boolean, verticalBias: Float) {
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