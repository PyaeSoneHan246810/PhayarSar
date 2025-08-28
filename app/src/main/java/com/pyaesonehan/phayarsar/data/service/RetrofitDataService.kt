package com.pyaesonehan.phayarsar.data.service

import com.pyaesonehan.phayarsar.domain.model.Detail
import com.pyaesonehan.phayarsar.domain.model.Group
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitDataService: DataService {
    @GET("phayar-sar")
    override suspend fun getGroups(): List<Group>

    @GET("phayar-sar/{groupId}/{detailId}")
    override suspend fun getDetail(@Path("groupId") groupId: Int, @Path("detailId") detailId: Int): Detail
}