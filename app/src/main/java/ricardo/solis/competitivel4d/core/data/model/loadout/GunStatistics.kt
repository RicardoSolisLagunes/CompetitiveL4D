package ricardo.solis.competitivel4d.core.data.model.loadout

import androidx.annotation.DrawableRes

data class GunStatistics(
    val name: String,
    val type: Gun,
    val kills: Int,
    val damage: Long,
    val gamesPlayed: Int
)