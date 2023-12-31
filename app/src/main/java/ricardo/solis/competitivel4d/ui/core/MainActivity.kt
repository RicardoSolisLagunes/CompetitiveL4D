package ricardo.solis.competitivel4d.ui.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ricardo.solis.competitivel4d.ui.screens.CompetitiveL4DApp
import ricardo.solis.competitivel4d.ui.theme.CompetitiveL4DTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompetitiveL4DTheme {
                CompetitiveL4DApp()
            }
        }
    }
}