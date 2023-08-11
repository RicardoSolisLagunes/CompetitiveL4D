package ricardo.solis.competitivel4d.core.data.repository

import ricardo.solis.competitivel4d.core.data.model.user.Profile

interface IProfileRepository {
    fun getProfile(): Profile
}