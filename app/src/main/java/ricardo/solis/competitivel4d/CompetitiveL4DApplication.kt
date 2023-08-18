package ricardo.solis.competitivel4d

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ricardo.solis.competitivel4d.di.appModule
import ricardo.solis.competitivel4d.di.dataModule

class CompetitiveL4DApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CompetitiveL4DApplication)
            modules(dataModule, appModule)
        }
    }

}