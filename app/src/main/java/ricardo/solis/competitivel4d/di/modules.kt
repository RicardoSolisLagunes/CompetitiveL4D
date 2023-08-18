package ricardo.solis.competitivel4d.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ricardo.solis.competitivel4d.data.mock.datasource.MockGunStatisticsDataSource
import ricardo.solis.competitivel4d.data.mock.datasource.MockHistoryDataSource
import ricardo.solis.competitivel4d.data.mock.datasource.MockProfileDataSource
import ricardo.solis.competitivel4d.data.repository.IGunStatisticsRepository
import ricardo.solis.competitivel4d.data.repository.IHistoryRepository
import ricardo.solis.competitivel4d.data.repository.IProfileRepository
import ricardo.solis.competitivel4d.ui.screens.dashboard.viewmodel.DashboardViewModel

val dataModule = module {
    single<IProfileRepository> {
        MockProfileDataSource()
    }

    single<IHistoryRepository> {
        MockHistoryDataSource()
    }

    single<IGunStatisticsRepository> {
        MockGunStatisticsDataSource()
    }
}

val appModule = module {
    viewModel {
        DashboardViewModel(
            profileRepository = get(),
            gunStatisticsRepository = get(),
            historyRepository = get()
        )
    }
}