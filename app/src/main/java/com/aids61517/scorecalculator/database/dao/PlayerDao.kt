package com.aids61517.scorecalculator.database.dao

import androidx.room.*
import com.aids61517.scorecalculator.database.entity.PlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    @Query("select * from ${PlayerEntity.TABLE_NAME}")
    fun observe(): Flow<List<PlayerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(playerEntity: PlayerEntity): Long

    @Query("select * from ${PlayerEntity.TABLE_NAME} where id = :id")
    fun getById(id: Long): PlayerEntity

//    @Query("select * from ${UserEntity.TABLE_NAME}")
//    fun getAll(): List<UserEntity>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(copyEntity: UserEntity)
//
//    @Query("delete from ${UserEntity.TABLE_NAME} where text = :text")
//    fun delete(text: String)
}