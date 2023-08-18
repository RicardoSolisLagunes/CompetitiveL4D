package ricardo.solis.competitivel4d.core.data.mock.datasource

import ricardo.solis.competitivel4d.R
import ricardo.solis.competitivel4d.core.data.model.loadout.Gun
import ricardo.solis.competitivel4d.core.data.model.loadout.GunStatistics
import ricardo.solis.competitivel4d.core.data.repository.IGunStatisticsRepository
import kotlin.random.Random

class MockGunStatisticsDataSource : IGunStatisticsRepository {
    override fun getFavoriteGun(): GunStatistics {
        val gun  = Gun.values()[Random.nextInt(from = 0, until = 3)]
        return GunStatistics(
            name = gun.name,
            damage = Random.nextLong(from = 1500, until = 100000),
            gamesPlayed = Random.nextInt(from = 10, until = 1000),
            type = gun,
            kills = Random.nextInt(from = 100, until = 10000)
        )
    }
}