package com.aids61517.scorecalculator.database.dao

import androidx.room.*
import com.aids61517.scorecalculator.database.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("select * from ${UserEntity.TABLE_NAME}")
    fun observe(): Flow<List<UserEntity>>

//    @Query("select * from ${UserEntity.TABLE_NAME}")
//    fun getAll(): List<UserEntity>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(copyEntity: UserEntity)
//
//    @Query("delete from ${UserEntity.TABLE_NAME} where text = :text")
//    fun delete(text: String)
}