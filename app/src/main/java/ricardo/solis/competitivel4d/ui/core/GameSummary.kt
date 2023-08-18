package ricardo.solis.competitivel4d.ui.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ricardo.solis.competitivel4d.R
import ricardo.solis.competitivel4d.data.model.history.ChapterScore
import ricardo.solis.competitivel4d.data.model.history.GameResult
import ricardo.solis.competitivel4d.data.model.history.GameScores
import ricardo.solis.competitivel4d.data.model.history.GameSummary
import ricardo.solis.competitivel4d.ui.theme.CompetitiveL4DTheme
import java.util.UUID

@Composable
fun GameSummaryView(
    gameSummary: GameSummary
) {
    Surface(
        Modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = gameSummary.map)
            GameResult(gameResult = gameSummary.result)
        }
    }
}

@Composable
fun GameResult(gameResult: GameResult) {
    val resultText: Pair<String, Color> = when (gameResult) {
        is GameResult.Win -> {
            Pair(
                stringResource(
                    id = R.string.game_won_label,
                    gameResult.mmr
                ),
                MaterialTheme.colorScheme.primary
            )
        }

        is GameResult.Tie -> {
            Pair(
                stringResource(
                    id = R.string.game_tied_label,
                    gameResult.mmr
                ),
                MaterialTheme.colorScheme.onBackground
            )
        }

        is GameResult.Loss -> {
            Pair(
                stringResource(
                    id = R.string.game_lost_label,
                    gameResult.mmr
                ),
                MaterialTheme.colorScheme.error
            )
        }

        else -> Pair("", Color.Black)
    }
    Text(
        text = resultText.first,
        color = resultText.second
    )
}

@Preview
@Composable
fun PreviewGameOverview() {
    CompetitiveL4DTheme {
        GameSummaryView(
            gameSummary = GameSummary(
                id = UUID.randomUUID(),
                map = "Dark Carnival",
                result = GameResult.Win(50),
                scores = GameScores(
                    listOf(
                        ChapterScore(500, 400),
                        ChapterScore(600, 500),
                        ChapterScore(700, 600)
                    )
                )
            )
        )
    }
}