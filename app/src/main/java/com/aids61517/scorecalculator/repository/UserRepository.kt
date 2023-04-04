package com.aids61517.scorecalculator.repository

import com.aids61517.scorecalculator.database.dao.UserDao
import com.aids61517.scorecalculator.database.entity.UserEntity
import com.aids61517.scorecalculator.model.User
import com.aids61517.scorecalculator.model.toUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Single

@Single
class UserRepository(
    private val userDao: UserDao,
) {
    fun observeAllUser(): Flow<List<User>> {
        return userDao.observe()
            .map { it.map { it.toUser() } }
    }

//    fun getAllCopy(): List<User> {
//        return userDao.getAll()
//            .map { it.toUser() }
//    }
//
//    fun insert(text: String) {
//        userDao.insert(UserEntity(text = text))
//    }
//
//    fun delete(text: String) {
//        userDao.delete(text)
//    }
}