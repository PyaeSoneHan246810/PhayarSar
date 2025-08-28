package com.pyaesonehan.phayarsar.data.repository

import com.pyaesonehan.phayarsar.data.service.DataService
import com.pyaesonehan.phayarsar.domain.model.Detail
import com.pyaesonehan.phayarsar.domain.repository.DetailRepository

class NetworkDetailRepository(
    private val dataService: DataService
): DetailRepository {
    override suspend fun getDetail(groupId: Int, detailId: Int): Detail {
        return dataService.getDetail(groupId, detailId)
    }
}