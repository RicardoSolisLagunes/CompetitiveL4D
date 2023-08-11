package ricardo.solis.competitivel4d.core.data.model.user

data class Profile(
    val id: String,
    val name: String,
    val imageUrl: String,
    val status: ProfileStatus
)

enum class ProfileStatus {
    Online,
    NeedsAuth,
    Invisible
}