package ricardo.solis.competitivel4d.core.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ricardo.solis.competitivel4d.core.data.model.user.Profile

@ExperimentalGlideComposeApi
@Composable
fun ProfileSummary(
    modifier: Modifier = Modifier,
    profile: Profile,
) {
    Column(modifier) {
        val textModifier = Modifier.fillMaxWidth()
        GlideImage(
            model = profile.imageUrl,
            contentDescription = profile.name,
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.onBackground)
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
                .align(Alignment.CenterHorizontally)
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
    }
}
