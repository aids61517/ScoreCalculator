package com.aids61517.scorecalculator.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = PlayerEntity.TABLE_NAME)
data class PlayerEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
) {
    companion object {
        const val TABLE_NAME = "player"
    }
}