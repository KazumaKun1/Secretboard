package com.arviejhay.secretboard

import android.app.Application
import org.koin.core.context.startKoin
import com.arviejhay.secretboard.di.appModule // Update this import if your DI module is named differently
import org.koin.android.ext.koin.androidContext

class SecretboardApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SecretboardApplication)
            modules(appModule)
        }
    }
}

