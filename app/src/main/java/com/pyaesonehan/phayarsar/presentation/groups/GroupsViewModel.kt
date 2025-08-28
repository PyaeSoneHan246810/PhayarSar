package com.pyaesonehan.phayarsar.presentation.groups

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pyaesonehan.phayarsar.app.MainApp
import com.pyaesonehan.phayarsar.domain.model.Group
import com.pyaesonehan.phayarsar.domain.repository.GroupsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class GroupsViewModel(
    private val groupsRepository: GroupsRepository
): ViewModel() {
    private val _groupsUiState: MutableStateFlow<GroupsUiState> = MutableStateFlow(GroupsUiState.Loading)
    val groupUiState: StateFlow<GroupsUiState> = _groupsUiState.asStateFlow()

    init {
        getGroups()
    }

    fun getGroups() {
        viewModelScope.launch {
            try {
                val groups = groupsRepository.getGroups()
                _groupsUiState.value = GroupsUiState.Success(groups)
            } catch (e: IOException) {
                e.printStackTrace()
                _groupsUiState.value = GroupsUiState.Failure
            }
        }
    }

    companion object {
        sealed interface GroupsUiState {
            data object Loading: GroupsUiState
            data object Failure: GroupsUiState
            data class Success(val groups: List<Group>): GroupsUiState
        }
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val mainApp = this[APPLICATION_KEY] as MainApp
                val groupsRepository = mainApp.appContainer.groupsRepository
                GroupsViewModel(
                    groupsRepository = groupsRepository
                )
            }
        }
    }
}