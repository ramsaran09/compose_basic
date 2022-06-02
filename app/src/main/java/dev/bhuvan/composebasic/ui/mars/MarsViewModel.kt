package dev.bhuvan.composebasic.ui.mars

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bhuvan.composebasic.model.MarsImageDataModel
import dev.bhuvan.composebasic.repository.MarsImageRepository
import dev.bhuvan.composebasic.responsehandler.CustomResponse
import kotlinx.coroutines.launch

class MarsViewModel(
    private val marsImageRepository: MarsImageRepository
) : ViewModel() {

    private val _marsState = mutableStateOf<MarsState>(MarsState.Loading)
    val marsState by _marsState

    init {
        viewModelScope.launch {
            when (val response = marsImageRepository.getMarsImageDataFromServer()) {
                is CustomResponse.Success -> {
                    _marsState.value = MarsState.Completed(response.data)
                }
                is CustomResponse.Failure -> {
                    _marsState.value = MarsState.Error(response.error.message)
                }
            }
        }
    }
}

sealed class MarsState {
    object Loading : MarsState()
    data class Completed(val marsImageDataModel: List<MarsImageDataModel>) : MarsState()
    data class Error(val msg : String) : MarsState()
}