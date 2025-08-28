package com.pyaesonehan.phayarsar.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Group(
    val groupId: Int,
    val title: String,
    val data: List<Item>
)