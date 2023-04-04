package com.aids61517.scorecalculator.injection

import com.aids61517.scorecalculator.database.AppDatabase
import com.aids61517.scorecalculator.database.dao.PlayerDao
import org.koin.core.annotation.Single

@Single
class PlayerDaoImpl(
    private val database: AppDatabase,
) : PlayerDao by database.userDao()