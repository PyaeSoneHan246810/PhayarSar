package com.pyaesonehan.phayarsar.data.repository

import com.pyaesonehan.phayarsar.data.service.DataService
import com.pyaesonehan.phayarsar.domain.model.Group
import com.pyaesonehan.phayarsar.domain.repository.GroupsRepository

class NetworkGroupsRepository(
    private val dataService: DataService
): GroupsRepository {
    override suspend fun getGroups(): List<Group> {
        return dataService.getGroups()
    }
}