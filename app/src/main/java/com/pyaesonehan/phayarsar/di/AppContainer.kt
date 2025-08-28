package com.pyaesonehan.phayarsar.di

import com.pyaesonehan.phayarsar.domain.repository.DetailRepository
import com.pyaesonehan.phayarsar.domain.repository.GroupsRepository

interface AppContainer {
    val groupsRepository: GroupsRepository

    val detailRepository: DetailRepository
}