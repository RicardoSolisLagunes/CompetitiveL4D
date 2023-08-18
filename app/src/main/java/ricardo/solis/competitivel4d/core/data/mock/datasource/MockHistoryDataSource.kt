package ricardo.solis.competitivel4d.core.data.mock.datasource

import ricardo.solis.competitivel4d.core.data.model.history.ChapterScore
import ricardo.solis.competitivel4d.core.data.model.history.GameResult
import ricardo.solis.competitivel4d.core.data.model.history.GameScores
import ricardo.solis.competitivel4d.core.data.model.history.GameSummary
import ricardo.solis.competitivel4d.core.data.repository.IHistoryRepository
import java.util.UUID

class MockHistoryDataSource : IHistoryRepository {
    override fun getMatchHistory(): List<GameSummary> {
        return listOf(
            GameSummary(
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
            ),
            GameSummary(
                id = UUID.randomUUID(),
                map = "Passifice",
                result = GameResult.Win(50),
                scores = GameScores(
                    listOf(
                        ChapterScore(500, 400),
                        ChapterScore(600, 500),
                        ChapterScore(700, 600)
                    )
                )
            ),
            GameSummary(
                id = UUID.randomUUID(),
                map = "No mercy",
                result = GameResult.Win(50),
                scores = GameScores(
                    listOf(
                        ChapterScore(500, 400),
                        ChapterScore(600, 500),
                        ChapterScore(700, 600)
                    )
                )
            ),
            GameSummary(
                id = UUID.randomUUID(),
                map = "The Parish",
                result = GameResult.Tie(0),
                scores = GameScores(
                    listOf(
                        ChapterScore(500, 500),
                        ChapterScore(600, 600),
                        ChapterScore(700, 700)
                    )
                )
            ),
            GameSummary(
                id = UUID.randomUUID(),
                map = "Dark Carnival",
                result = GameResult.Loss(-50),
                scores = GameScores(
                    listOf(
                        ChapterScore(50, 400),
                        ChapterScore(150, 500),
                        ChapterScore(300, 600)
                    )
                )
            )
        )
    }
}