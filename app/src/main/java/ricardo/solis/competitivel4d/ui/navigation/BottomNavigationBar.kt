package ricardo.solis.competitivel4d.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ricardo.solis.competitivel4d.R

data class BottomNavItem(
    val label: Int,
    val icon: ImageVector,
    val route: String
)

object BottomNavigationItems {
    val Destinations = listOf(
        BottomNavItem(
            label = R.string.dashboard_screen_navigation_label,
            icon = Icons.Filled.Info,
            route = "dashboard"
        )
    )
}

@Composable
fun CompetitiveL4DBottomNavigationBar(navController: NavController) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        BottomNavigationItems.Destinations.forEach { navItem ->
            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route)
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = stringResource(id = navItem.label)
                    )
                },
                label = {
                    Text(text = stringResource(id = navItem.label))
                },
                alwaysShowLabel = false
            )
        }
    }
}