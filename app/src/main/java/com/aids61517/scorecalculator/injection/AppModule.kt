package com.aids61517.scorecalculator.injection

import android.app.Application
import com.aids61517.scorecalculator.database.AppDatabase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.aids61517.scorecalculator")
class AppModule {
    @Single
    fun provideDatabase(application: Application): AppDatabase {
        return AppDatabase.createInstance(application)
    }
}