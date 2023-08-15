package ricardo.solis.competitivel4d.core.data.repository

import ricardo.solis.competitivel4d.core.data.model.history.GameSummary

interface IHistoryRepository {
    fun getMatchHistory(): List<GameSummary>
}