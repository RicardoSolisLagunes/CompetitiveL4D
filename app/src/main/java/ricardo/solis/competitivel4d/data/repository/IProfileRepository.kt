package ricardo.solis.competitivel4d.data.repository

import ricardo.solis.competitivel4d.data.model.user.Profile

interface IProfileRepository {
    fun getProfile(): Profile
}