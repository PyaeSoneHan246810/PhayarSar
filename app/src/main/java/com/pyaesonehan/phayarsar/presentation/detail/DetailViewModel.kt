package com.pyaesonehan.phayarsar.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pyaesonehan.phayarsar.app.MainApp
import com.pyaesonehan.phayarsar.domain.model.Detail
import com.pyaesonehan.phayarsar.domain.repository.DetailRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class DetailViewModel(
    private val detailRepository: DetailRepository
): ViewModel() {
    private val _detailUiState: MutableStateFlow<DetailUiState> = MutableStateFlow(DetailUiState.Loading)
    val detailUiState: StateFlow<DetailUiState> = _detailUiState.asStateFlow()

    fun getDetail(groupId: Int, detailId: Int) {
        viewModelScope.launch {
            try {
                val detail = detailRepository.getDetail(groupId, detailId)
                _detailUiState.value = DetailUiState.Success(detail)
            } catch (e: IOException) {
                e.printStackTrace()
                _detailUiState.value = DetailUiState.Failure
            }
        }
    }

    companion object {
        sealed interface DetailUiState {
            data object Loading: DetailUiState
            data object Failure: DetailUiState
            data class Success(val detail: Detail): DetailUiState
        }
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val mainApp = this[APPLICATION_KEY] as MainApp
                val detailRepository = mainApp.appContainer.detailRepository
                DetailViewModel(
                    detailRepository = detailRepository
                )
            }
        }
    }
}