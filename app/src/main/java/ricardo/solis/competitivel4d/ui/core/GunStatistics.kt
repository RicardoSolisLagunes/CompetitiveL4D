package ricardo.solis.competitivel4d.ui.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ricardo.solis.competitivel4d.R
import ricardo.solis.competitivel4d.data.model.loadout.GunStatistics
import ricardo.solis.competitivel4d.data.mock.datasource.MockGunStatisticsDataSource
import ricardo.solis.competitivel4d.ui.theme.CompetitiveL4DTheme
import ricardo.solis.competitivel4d.ui.util.gunIcon

@Composable
fun GunStatistics(
    gunStatistics: GunStatistics
) {
    val gunIcon = gunStatistics.type.gunIcon()
    val painter = painterResource(id = gunIcon)
    Surface(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        color = Color.Transparent
    ) {
        Row {
            Image(
                painter = painter,
                contentDescription = gunStatistics.name,
                Modifier
                    .padding(8.dp)
                    .heightIn(80.dp, 100.dp)
                    .widthIn(80.dp, 100.dp)
                    .fillMaxSize()
            )
            Column(
                Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp)
            ) {
                Text(
                    text = gunStatistics.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                val modifier = Modifier.fillMaxWidth()
                PairData(
                    modifier = modifier,
                    label = R.string.games_played_with_gun,
                    data = gunStatistics.gamesPlayed.toString()
                )
                PairData(
                    modifier = modifier,
                    label = R.string.damage_dealt_with_gun,
                    data = gunStatistics.damage.toString()
                )
                PairData(
                    modifier = modifier,
                    label = R.string.kills_with_gun,
                    data = gunStatistics.kills.toString()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoadOut() {
    CompetitiveL4DTheme {
        GunStatistics(
            gunStatistics = MockGunStatisticsDataSource().getFavoriteGun()
        )
    }
}