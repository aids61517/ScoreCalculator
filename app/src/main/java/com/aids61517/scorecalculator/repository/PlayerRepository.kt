package com.aids61517.scorecalculator.repository

import com.aids61517.scorecalculator.database.dao.PlayerDao
import com.aids61517.scorecalculator.model.Player
import com.aids61517.scorecalculator.model.toPlayer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Single

@Single
class PlayerRepository(
    private val playerDao: PlayerDao,
) {
    fun observeAllPlayer(): Flow<List<Player>> {
        return playerDao.observe()
            .map { it.map { it.toPlayer() } }
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