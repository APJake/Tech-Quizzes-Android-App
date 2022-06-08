package com.apjake.techquizzes.presentation.mvvm.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apjake.techquizzes.domain.usecase.GetProfileUseCase
import com.apjake.techquizzes.domain.usecase.GetQuizHeadersUseCase
import com.apjake.techquizzes.presentation.mvvm.event.HomeUiEvent
import com.apjake.techquizzes.presentation.mvvm.mapper.QuizHeadersUiMapper
import com.apjake.techquizzes.presentation.mvvm.mapper.UserProfileUiMapper
import com.apjake.techquizzes.presentation.mvvm.state.HomeUiState
import com.apjake.techquizzes.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getQuizHeadersUseCase: GetQuizHeadersUseCase,
    private val getProfileUseCase: GetProfileUseCase
): ViewModel() {

    private val _event = MutableSharedFlow<HomeUiEvent>()
    val event = _event.asSharedFlow()

    private val _state = mutableStateOf(HomeUiState())
    val state = _state

    private val quizHeadersUiMapper = QuizHeadersUiMapper()
    private val profileUiMapper = UserProfileUiMapper()

    init {
        reload()
    }

    fun reload(){
        loadProfileData()
        loadQuizData()
    }

    private fun loadProfileData(){
        viewModelScope.launch {
            _state.value = _state.value.copy(
                profileLoading = true
            )
            val profile = getProfileUseCase()
            _state.value = _state.value.copy(
                profileLoading = false,
            )
            if(profile!=null){
                _state.value = _state.value.copy(
                    profile = profileUiMapper.map(profile)
                )
            }
        }
    }

    private fun loadQuizData(){
        viewModelScope.launch {
            getQuizHeadersUseCase().collectLatest {
                when(it){
                    is Resource.Loading->{
                        _state.value = _state.value.copy(
                            quizLoading = true
                        )
                    }
                    is Resource.Error ->{
                        _event.emit(
                            HomeUiEvent.ShowErrorSnackBar(it.message?:"Unknown error")
                        )
                    }
                    is Resource.Success ->{
                        _state.value = _state.value.copy(
                            quizLoading = false,
                            quizList = quizHeadersUiMapper.map(it.data.orEmpty())
                        )
                    }
                }
            }
        }
    }

}