package com.aids61517.scorecalculator.database

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aids61517.scorecalculator.database.dao.PlayerDao
import com.aids61517.scorecalculator.database.entity.PlayerEntity

@androidx.room.Database(entities = [PlayerEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): PlayerDao

    companion object {
        fun createInstance(application: Application): AppDatabase = buildDatabase(application)

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "AppDatabase.db"
            )
                .build()
    }
}