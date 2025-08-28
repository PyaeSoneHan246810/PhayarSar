package com.pyaesonehan.phayarsar.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Detail(
    val id: Int,
    val groupId: Int,
    val title: String,
    val content: String
)