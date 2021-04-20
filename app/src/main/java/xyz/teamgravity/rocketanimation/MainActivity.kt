package xyz.teamgravity.rocketanimation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val animationState = remember { mutableStateOf(false) }

            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
            ) {
                Rocket(
                    isRocketEnabled = animationState.value,
                    maxWidth = maxWidth,
                    maxHeight = maxHeight,
                    rocketSize = 200.dp
                )

                LaunchButton(animationState = animationState.value) {
                    animationState.value = !animationState.value
                }
            }
        }
    }
}