@file:OptIn(ExperimentalGlideComposeApi::class)

package ricardo.solis.competitivel4d.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ricardo.solis.competitivel4d.R
import ricardo.solis.competitivel4d.core.data.model.history.ChapterScore
import ricardo.solis.competitivel4d.core.data.model.history.GameResult
import ricardo.solis.competitivel4d.core.data.model.history.GameScores
import ricardo.solis.competitivel4d.core.data.model.history.GameSummary
import ricardo.solis.competitivel4d.core.data.model.loadout.GunStatistics
import ricardo.solis.competitivel4d.core.data.model.user.Profile
import ricardo.solis.competitivel4d.core.data.model.user.ProfileStatus
import ricardo.solis.competitivel4d.core.ui.history.MatchHistory
import ricardo.solis.competitivel4d.core.ui.loadout.GunStatistics
import ricardo.solis.competitivel4d.ui.theme.CompetitiveL4DTheme

@Composable
fun Profile(
    modifier: Modifier = Modifier,
    profile: Profile,
    gunStatistics: GunStatistics,
    matches: List<GameSummary>
) {
    Surface(modifier) {
        Column(modifier.padding(12.dp)) {
            val textModifier = Modifier.fillMaxWidth()
            GlideImage(
                model = profile.imageUrl, contentDescription = profile.name, modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
                    .align(Alignment.CenterHorizontally)
                    .sizeIn(
                        minHeight = 120.dp,
                        minWidth = 120.dp,
                        maxHeight = 190.dp,
                        maxWidth = 190.dp
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = RoundedCornerShape(12.dp)
                    )
            )
            Text(
                text = profile.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = textModifier
            )
            Text(
                text = profile.id,
                textAlign = TextAlign.Center,
                modifier = textModifier
            )
            Divider(
                Modifier.padding(top = 20.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.primary
            )
            ElevatedCard(
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 12.dp
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            ) {
                Text(
                    text = stringResource(id = R.string.favorite_gun_title),
                    Modifier.padding(12.dp),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                GunStatistics(gunStatistics = gunStatistics)
            }
            ElevatedCard(
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 12.dp
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            ) {
                Text(
                    text = stringResource(id = R.string.match_history_title),
                    Modifier.padding(12.dp),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                MatchHistory(matches = matches)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfile() {
    val gunStatistics = GunStatistics(
        name = "Chrome Shotgun",
        damage = 999999,
        gamesPlayed = 50,
        icon = R.drawable.shotgun_icon,
        kills = 100
    )
    val profile = Profile(
        id = "STEAM_1234567890",
        name = "Juanito Banana",
        imageUrl = "https://avatars.cloudflare.steamstatic.com/8263c05e4ce80b161d56fa604880fbe7641f00da_full.jpg",
        status = ProfileStatus.Online
    )
    CompetitiveL4DTheme {
        Profile(
            Modifier.fillMaxSize(),
            profile,
            gunStatistics,
            listOf(
                GameSummary(
                    map = "Dark Carnival",
                    result = GameResult.Win(50),
                    scores = GameScores(
                        listOf(
                            ChapterScore(500, 400),
                            ChapterScore(600, 500),
                            ChapterScore(700, 600)
                        )
                    )
                ),
                GameSummary(
                    map = "Passifice",
                    result = GameResult.Win(50),
                    scores = GameScores(
                        listOf(
                            ChapterScore(500, 400),
                            ChapterScore(600, 500),
                            ChapterScore(700, 600)
                        )
                    )
                ),
                GameSummary(
                    map = "No mercy",
                    result = GameResult.Win(50),
                    scores = GameScores(
                        listOf(
                            ChapterScore(500, 400),
                            ChapterScore(600, 500),
                            ChapterScore(700, 600)
                        )
                    )
                ),
                GameSummary(
                    map = "The Parish",
                    result = GameResult.Tie(0),
                    scores = GameScores(
                        listOf(
                            ChapterScore(500, 500),
                            ChapterScore(600, 600),
                            ChapterScore(700, 700)
                        )
                    )
                ),
                GameSummary(
                    map = "Dark Carnival",
                    result = GameResult.Loss(-50),
                    scores = GameScores(
                        listOf(
                            ChapterScore(50, 400),
                            ChapterScore(150, 500),
                            ChapterScore(300, 600)
                        )
                    )
                )
            )

        )
    }
}