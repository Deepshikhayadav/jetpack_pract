package com.deepshikhayadav.tstjet

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun MyTabRow(
    allScreens: List<MyScreens>,
    onTabSelected: (MyScreens) -> Unit,
    currentScreen: MyScreens
) {
    Surface(
        androidx.compose.ui.Modifier
            .height(TabHeight)
            .fillMaxWidth()
    ) {
        Row(Modifier.selectableGroup()) {
            allScreens.forEach { screen ->
                MyTab(
                    text = screen.name,
                    icon = screen.icon,
                    onSelected = { onTabSelected(screen) },
                    selected = currentScreen == screen
                )
            }
        }
    }
}
private val TabHeight = 56.dp
@Composable
fun MyTab(text: String, icon: ImageVector, onSelected: () -> Unit, selected: Boolean) {

}
