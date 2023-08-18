package ricardo.solis.competitivel4d.data.repository

import ricardo.solis.competitivel4d.data.model.history.GameSummary

interface IHistoryRepository {
    fun getMatchHistory(): List<GameSummary>
}