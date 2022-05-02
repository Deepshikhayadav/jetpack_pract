package com.deepshikhayadav.tstjet

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

enum class MyScreens(val icon: ImageVector,
                     val body: @Composable ((String) -> Unit) -> Unit) {
    Overview(
        icon = Icons.Filled.Home,
        body = { OverviewBody() }
    ),
    StepCounter(
        icon = Icons.Filled.Face,
        body = { StepCountBody(com.deepshikhayadav.tstjet.data.UserData.accounts) }
    ),
    Settings(
        icon = Icons.Filled.Settings,
        body = { SettingBody(com.deepshikhayadav.tstjet.data.UserData.Settings) }
    );

    @Composable
    fun content(onScreenChange: (String) -> Unit) {
        body(onScreenChange)
    }
}