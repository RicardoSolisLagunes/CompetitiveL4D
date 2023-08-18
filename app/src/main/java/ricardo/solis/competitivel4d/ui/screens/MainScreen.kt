package ricardo.solis.competitivel4d.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ricardo.solis.competitivel4d.R
import ricardo.solis.competitivel4d.ui.navigation.CompetitiveL4DBottomNavigationBar
import ricardo.solis.competitivel4d.ui.screens.dashboard.composable.Dashboard

enum class Screen(@StringRes val title: Int) {
    Dashboard(title = R.string.dashboard_screen_title)
}

@Composable
fun CompetitiveL4DAppBar(
    screen: Screen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
) {
    TopAppBar(
        title = { Text(text = stringResource(id = screen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button_content_description)
                    )
                }
            }
        }
    )
}

@Composable
fun CompetitiveL4DApp(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = Screen.valueOf(
        backStackEntry?.destination?.route ?: Screen.Dashboard.name
    )

    Scaffold(
        topBar = {
            CompetitiveL4DAppBar(
                screen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = navController::navigateUp
            )
        },
        bottomBar = {
            CompetitiveL4DBottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Dashboard.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Screen.Dashboard.name) {
                Dashboard()
            }
        }
    }
}