package com.example.dz22_dependency_inject_hilt.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dz22_dependency_inject_hilt.Response.Repository
import com.example.dz22_dependency_inject_hilt.model.ResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResponseModelViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>(Empty)
    val uiState: LiveData<UiState> = _uiState

    fun getCryptoByName(name: String) {
        _uiState.value = Processing
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCryptoByName(name = name)
            try {
                if (response.isSuccessful) {
                    _uiState.postValue(
                        response.body()?.let { responseModel -> Success(model = responseModel) })
                } else {
                    _uiState.postValue(Error(error = response.code().toString()))
                }
            } catch (e: Exception) {
                _uiState.postValue(Error(error = e.message.toString()))
            }
        }
    }

    sealed class UiState()
    data object Empty : UiState()
    data object Processing : UiState()
    class Success(val model: ResponseModel) : UiState()
    class Error(val error: String) : UiState()
}