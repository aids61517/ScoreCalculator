package com.aids61517.scorecalculator.model

import com.aids61517.scorecalculator.database.entity.PlayerEntity

data class Player(
    val id: Long,
    val name: String,
    val active: Boolean,
)

fun Player.toEntity() = PlayerEntity(
    id = id,
    name = name,
    active = active,
)

fun PlayerEntity.toPlayer() = Player(
    id = id,
    name = name,
    active = active,
)