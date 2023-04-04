package com.aids61517.scorecalculator.injection

import com.aids61517.scorecalculator.database.AppDatabase
import com.aids61517.scorecalculator.database.dao.UserDao
import org.koin.core.annotation.Single

@Single
class UserDaoImpl(
    private val database: AppDatabase,
) : UserDao by database.userDao()