import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {
            // Provide the Android context
            androidContext(this@MyApplication)
            // Load Koin modules
            modules(appModule) // 'appModule' is the module where you declare your dependencies
        }
    }
}
