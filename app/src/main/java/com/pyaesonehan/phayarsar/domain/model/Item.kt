package com.pyaesonehan.phayarsar.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val id: Int,
    val groupId: Int,
    val title: String
)