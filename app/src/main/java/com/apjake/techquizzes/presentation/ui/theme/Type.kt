package com.apjake.techquizzes.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.apjake.techquizzes.R

val latoFont = FontFamily(
    Font(R.font.lato_thin, FontWeight.Thin, FontStyle.Normal),
    Font(R.font.lato_thin_italic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.lato_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.lato_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.lato_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.lato_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.lato_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.lato_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.lato_black, FontWeight.Black, FontStyle.Normal),
    Font(R.font.lato_black, FontWeight.Black, FontStyle.Italic),
)

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.Medium,
        fontSize = 26.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.2.sp
    ),
    bodySmall = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 12.sp
    ),
    labelLarge = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    labelMedium = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    labelSmall = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.Light,
    ),
    headlineLarge = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.Black,
        fontSize = 24.sp,
        lineHeight = 16.sp,
        letterSpacing = 1.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 19.sp,
        lineHeight = 16.sp,
        letterSpacing = 1.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 1.sp
    ),
    displayLarge = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.Black,
        fontSize = 30.sp,
        letterSpacing = 0.2.sp
    ),
    displayMedium = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.Black,
        fontSize = 24.sp,
        letterSpacing = 0.2.sp
    ),
    displaySmall = TextStyle(
        fontFamily = latoFont,
        fontWeight = FontWeight.Black,
        fontSize = 22.sp,
        letterSpacing = 0.2.sp
    ),
)