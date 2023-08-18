package ricardo.solis.competitivel4d.data.repository

import ricardo.solis.competitivel4d.data.model.loadout.GunStatistics

interface IGunStatisticsRepository {
    fun getFavoriteGun(): GunStatistics
}