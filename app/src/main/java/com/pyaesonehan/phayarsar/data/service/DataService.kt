package com.pyaesonehan.phayarsar.data.service

import com.pyaesonehan.phayarsar.domain.model.Detail
import com.pyaesonehan.phayarsar.domain.model.Group

interface DataService {
    suspend fun getGroups(): List<Group>

    suspend fun getDetail(groupId: Int, detailId: Int): Detail
}