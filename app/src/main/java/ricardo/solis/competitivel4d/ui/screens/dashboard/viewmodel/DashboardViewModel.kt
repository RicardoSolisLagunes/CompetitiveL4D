package ricardo.solis.competitivel4d.ui.screens.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import ricardo.solis.competitivel4d.data.model.history.GameSummary
import ricardo.solis.competitivel4d.data.model.loadout.GunStatistics
import ricardo.solis.competitivel4d.data.model.user.Profile
import ricardo.solis.competitivel4d.data.repository.IGunStatisticsRepository
import ricardo.solis.competitivel4d.data.repository.IHistoryRepository
import ricardo.solis.competitivel4d.data.repository.IProfileRepository

class DashboardViewModel(
    private val profileRepository: IProfileRepository,
    private val gunStatisticsRepository: IGunStatisticsRepository,
    private val historyRepository: IHistoryRepository
) : ViewModel() {
    fun getProfile(): Profile {
        return profileRepository.getProfile()
    }

    fun getFavoriteGun(): GunStatistics {
        return gunStatisticsRepository.getFavoriteGun()
    }

    fun getMatchHistory(): List<GameSummary> {
        return historyRepository.getMatchHistory()
    }

}