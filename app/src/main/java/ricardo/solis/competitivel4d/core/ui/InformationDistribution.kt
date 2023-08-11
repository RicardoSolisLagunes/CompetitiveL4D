package ricardo.solis.competitivel4d.core.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp

@Composable
fun PairData(modifier: Modifier = Modifier,
    @StringRes label: Int,
    data: String
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = label),
            fontSize = 15.sp
        )
        Text(
            text = data,
            fontSize = 15.sp
        )
    }
}