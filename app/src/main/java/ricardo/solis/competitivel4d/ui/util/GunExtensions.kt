package ricardo.solis.competitivel4d.ui.util

import androidx.annotation.DrawableRes
import ricardo.solis.competitivel4d.R
import ricardo.solis.competitivel4d.core.data.model.loadout.Gun

@DrawableRes
fun Gun.gunIcon(): Int {
    return when (this) {
        Gun.ChromeShotgun -> R.drawable.ic_chrome_shotgun
        Gun.PumpShotgun -> R.drawable.ic_pump_shotgun
        Gun.Smg -> R.drawable.ic_smg
        Gun.SilencedSmg -> R.drawable.ic_silenced_smg
    }
}
