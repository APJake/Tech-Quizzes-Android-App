package com.apjake.techquizzes.presentation.util

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object QuizScreen: Screen("quiz_screen")
}