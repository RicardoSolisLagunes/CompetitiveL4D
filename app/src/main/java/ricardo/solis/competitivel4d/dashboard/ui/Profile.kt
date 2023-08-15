package ricardo.solis.competitivel4d.dashboard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import ricardo.solis.competitivel4d.R
import ricardo.solis.competitivel4d.core.data.repository.IGunStatisticsRepository
import ricardo.solis.competitivel4d.core.data.repository.IHistoryRepository
import ricardo.solis.competitivel4d.core.data.repository.IProfileRepository
import ricardo.solis.competitivel4d.core.ui.DetailsCard
import ricardo.solis.competitivel4d.core.ui.history.MatchHistory
import ricardo.solis.competitivel4d.core.ui.loadout.GunStatistics
import ricardo.solis.competitivel4d.core.ui.profile.ProfileSummary
import ricardo.solis.competitivel4d.mock.datasource.MockGunStatisticsDataSource
import ricardo.solis.competitivel4d.mock.datasource.MockHistoryDataSource
import ricardo.solis.competitivel4d.mock.datasource.MockProfileDataSource
import ricardo.solis.competitivel4d.ui.theme.CompetitiveL4DTheme

@ExperimentalGlideComposeApi
@Composable
fun Dashboard(
    modifier: Modifier = Modifier,
    profileRepository: IProfileRepository,
    gunStatisticsRepository: IGunStatisticsRepository,
    historyRepository: IHistoryRepository
) {
    Column(modifier.padding(12.dp)) {
        ProfileSummary(
            profile = profileRepository.getProfile(),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Divider(
            Modifier.padding(top = 20.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.primary
        )
        DetailsCard {
            Text(
                text = stringResource(id = R.string.favorite_gun_title),
                Modifier.padding(12.dp),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            GunStatistics(gunStatistics = gunStatisticsRepository.getFavoriteGun())
        }
        DetailsCard {
            Text(
                text = stringResource(id = R.string.match_history_title),
                Modifier.padding(12.dp),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            MatchHistory(matches = historyRepository.getMatchHistory())
        }
    }
}

@ExperimentalGlideComposeApi
@Preview(showBackground = true)
@Composable
fun PreviewDashboard() {
    CompetitiveL4DTheme {
        Dashboard(
            modifier = Modifier.fillMaxSize(),
            profileRepository = MockProfileDataSource(),
            gunStatisticsRepository = MockGunStatisticsDataSource(),
            historyRepository = MockHistoryDataSource()
        )
    }
}