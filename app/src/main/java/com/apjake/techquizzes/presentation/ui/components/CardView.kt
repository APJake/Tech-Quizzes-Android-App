package com.apjake.techquizzes.presentation.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.apjake.techquizzes.presentation.ui.theme.*

@Composable
fun CardView(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    cornerRadius: Dp = RadiusSmall,
    shadowElevation: Dp = ElevationMedium,
    onClick: (()-> Unit)? = null,
    content: @Composable () -> Unit
) {
    Surface(
        color = backgroundColor,
        modifier = modifier,
        shadowElevation = shadowElevation,
        shape = RoundedCornerShape(cornerRadius),
    ){
        content()
    }
}