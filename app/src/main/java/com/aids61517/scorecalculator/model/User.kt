package com.aids61517.scorecalculator.model

import com.aids61517.scorecalculator.database.entity.UserEntity

data class User(
    val id: Int,
    val name: String,
)

fun User.toEntity() = UserEntity(
    id = id,
    name = name,
)

fun UserEntity.toUser() = User(
    id = id,
    name = name,
)