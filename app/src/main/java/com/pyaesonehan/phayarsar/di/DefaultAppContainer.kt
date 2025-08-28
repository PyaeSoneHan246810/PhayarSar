package com.pyaesonehan.phayarsar.di

import com.pyaesonehan.phayarsar.data.repository.NetworkDetailRepository
import com.pyaesonehan.phayarsar.data.repository.NetworkGroupsRepository
import com.pyaesonehan.phayarsar.data.service.RetrofitDataService
import com.pyaesonehan.phayarsar.domain.repository.DetailRepository
import com.pyaesonehan.phayarsar.domain.repository.GroupsRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class DefaultAppContainer: AppContainer {

    private val baseUrl: String = "https://burma-project-ideas.vercel.app"

    private val retrofit: Retrofit = Retrofit
        .Builder()
        .addConverterFactory(Json.asConverterFactory(contentType = "application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitDataService: RetrofitDataService by lazy {
        retrofit.create(RetrofitDataService::class.java)
    }

    override val groupsRepository: GroupsRepository by lazy {
        NetworkGroupsRepository(
            dataService = retrofitDataService
        )
    }

    override val detailRepository: DetailRepository by lazy {
        NetworkDetailRepository(
            dataService = retrofitDataService
        )
    }
}