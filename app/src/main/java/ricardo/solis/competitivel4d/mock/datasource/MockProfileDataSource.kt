package ricardo.solis.competitivel4d.mock.datasource

import ricardo.solis.competitivel4d.core.data.model.user.Profile
import ricardo.solis.competitivel4d.core.data.model.user.ProfileStatus
import ricardo.solis.competitivel4d.core.data.repository.IProfileRepository

class MockProfileDataSource: IProfileRepository {
    override fun getProfile(): Profile {
        return Profile(
            id = "STEAM_1234567890",
            name = "Juanito Banana",
            imageUrl = "https://avatars.cloudflare.steamstatic.com/8263c05e4ce80b161d56fa604880fbe7641f00da_full.jpg",
            status = ProfileStatus.Online
        )
    }
}