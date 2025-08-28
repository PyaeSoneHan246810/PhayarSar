package com.pyaesonehan.phayarsar.domain.repository

import com.pyaesonehan.phayarsar.domain.model.Group

interface GroupsRepository {
    suspend fun getGroups(): List<Group>
}