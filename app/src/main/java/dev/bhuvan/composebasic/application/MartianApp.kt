package dev.bhuvan.composebasic.application

import android.app.Application
import dev.bhuvan.composebasic.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class ComposeBasic : Application() {

    override fun onCreate() {
        super.onCreate()
        configKoin()
    }

    private fun configKoin() {
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@ComposeBasic)
            modules(AppModule.appModules())
        }
    }
}