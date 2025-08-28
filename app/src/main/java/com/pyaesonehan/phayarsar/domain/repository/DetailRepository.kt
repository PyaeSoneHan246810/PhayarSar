package com.pyaesonehan.phayarsar.domain.repository

import com.pyaesonehan.phayarsar.domain.model.Detail

interface DetailRepository {
    suspend fun getDetail(groupId: Int, detailId: Int): Detail
}