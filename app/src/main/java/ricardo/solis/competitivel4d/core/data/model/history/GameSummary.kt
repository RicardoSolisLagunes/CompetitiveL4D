package ricardo.solis.competitivel4d.core.data.model.history

import java.util.UUID

data class GameSummary(
    val id: UUID,
    val map: String,
    val result: GameResult,
    val scores: GameScores
)