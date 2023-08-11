package ricardo.solis.competitivel4d.core.ui.history

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ricardo.solis.competitivel4d.core.data.model.history.ChapterScore
import ricardo.solis.competitivel4d.core.data.model.history.GameScores
import ricardo.solis.competitivel4d.core.data.model.history.GameSummary
import ricardo.solis.competitivel4d.ui.theme.CompetitiveL4DTheme

@Composable
fun MatchHistory(
    matches: List<GameSummary>
) {
    LazyColumn {
        items(matches) { gameSummary ->
            GameSummaryView(gameSummary = gameSummary)
        }
    }
}

@Preview
@Composable
fun PreviewHistory() {
    CompetitiveL4DTheme {
        MatchHistory(
            matches = listOf(
                GameSummary(
                    map = "Dark Carnival",
                    result = ricardo.solis.competitivel4d.core.data.model.history.GameResult.Win(50),
                    scores = GameScores(
                        listOf(
                            ChapterScore(500, 400),
                            ChapterScore(600, 500),
                            ChapterScore(700, 600)
                        )
                    )
                ),
                GameSummary(
                    map = "Dark Carnival",
                    result = ricardo.solis.competitivel4d.core.data.model.history.GameResult.Win(50),
                    scores = GameScores(
                        listOf(
                            ChapterScore(500, 400),
                            ChapterScore(600, 500),
                            ChapterScore(700, 600)
                        )
                    )
                ),
                GameSummary(
                    map = "Dark Carnival",
                    result = ricardo.solis.competitivel4d.core.data.model.history.GameResult.Win(50),
                    scores = GameScores(
                        listOf(
                            ChapterScore(500, 400),
                            ChapterScore(600, 500),
                            ChapterScore(700, 600)
                        )
                    )
                ),
                GameSummary(
                    map = "Dark Carnival",
                    result = ricardo.solis.competitivel4d.core.data.model.history.GameResult.Win(50),
                    scores = GameScores(
                        listOf(
                            ChapterScore(500, 400),
                            ChapterScore(600, 500),
                            ChapterScore(700, 600)
                        )
                    )
                ),
                GameSummary(
                    map = "Dark Carnival",
                    result = ricardo.solis.competitivel4d.core.data.model.history.GameResult.Win(50),
                    scores = GameScores(
                        listOf(
                            ChapterScore(500, 400),
                            ChapterScore(600, 500),
                            ChapterScore(700, 600)
                        )
                    )
                )
            )
        )
    }
}