package com.aids61517.scorecalculator

import android.app.Application
import com.aids61517.scorecalculator.injection.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class ScoreCalculatorApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ScoreCalculatorApplication)
            modules(
                AppModule().module,
            )
        }
    }
}