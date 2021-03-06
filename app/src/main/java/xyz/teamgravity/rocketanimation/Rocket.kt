package xyz.teamgravity.rocketanimation

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun Rocket(
    isRocketEnabled: Boolean,
    maxWidth: Dp,
    maxHeight: Dp,
    rocketSize: Dp
) {
    // recourse image
    val painter: Painter

    // position manipulator
    val modifier: Modifier

    if (isRocketEnabled) {
        // remember infinite transition state
        val infiniteTransition = rememberInfiniteTransition()

        // build animation
        val engineState = infiniteTransition.animateFloat(
            // start value
            initialValue = 0f,
            // finish value
            targetValue = 1f,
            // animation type -> infinite
            animationSpec = infiniteRepeatable(
                // tween simple animation
                animation = tween(
                    // duration
                    durationMillis = 300,
                    // just simple linear going
                    easing = LinearEasing
                )
            )
        )

        val positionState = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                )
            )
        )

        // get two animations
        painter = if (engineState.value <= 0.5f) {
            painterResource(id = R.drawable.rocket1)
        } else {
            painterResource(id = R.drawable.rocket2)
        }

        modifier = Modifier.offset(
            x = (maxWidth - rocketSize) * positionState.value,
            y = (maxHeight - rocketSize) - (maxHeight - rocketSize) * positionState.value
        )
    } else {

        painter = painterResource(id = R.drawable.rocket_intial)
        modifier = Modifier.offset(y = maxHeight - rocketSize)
    }

    // image
    Image(
        painter = painter,
        contentDescription = "raheem",
        modifier = modifier
            .height(rocketSize)
            .width(rocketSize)
    )
}