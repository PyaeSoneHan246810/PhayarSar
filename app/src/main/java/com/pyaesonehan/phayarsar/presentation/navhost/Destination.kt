package com.pyaesonehan.phayarsar.presentation.navhost

import kotlinx.serialization.Serializable

object Destination {
    @Serializable
    data object GroupsScreen

    @Serializable
    data class DetailScreen(
        val groupId: Int,
        val detailId: Int
    )
}