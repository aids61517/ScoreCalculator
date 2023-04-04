package com.aids61517.scorecalculator.model

import com.aids61517.scorecalculator.database.entity.PlayerEntity

data class Player(
    val id: Int,
    val name: String,
)

fun Player.toEntity() = PlayerEntity(
    id = id,
    name = name,
)

fun PlayerEntity.toPlayer() = Player(
    id = id,
    name = name,
)