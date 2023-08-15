package ricardo.solis.competitivel4d.core.data.repository

import ricardo.solis.competitivel4d.core.data.model.loadout.GunStatistics

interface IGunStatisticsRepository {
    fun getFavoriteGun(): GunStatistics
}