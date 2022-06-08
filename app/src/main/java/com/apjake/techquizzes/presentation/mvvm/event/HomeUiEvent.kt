package com.apjake.techquizzes.presentation.mvvm.event

sealed class HomeUiEvent {
    data class ShowErrorSnackBar(val message: String): HomeUiEvent()
}