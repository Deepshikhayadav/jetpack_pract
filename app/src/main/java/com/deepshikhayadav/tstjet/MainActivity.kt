package com.deepshikhayadav.tstjet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.deepshikhayadav.tstjet.ui.theme.TstJetTheme
import kotlin.reflect.KProperty

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MyApp()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

        MyApp()

}

@Composable
fun MyApp() {
    TstJetTheme {
        val allScreens = MyScreens.values().toList()
        var currentScreen by rememberSaveable { mutableStateOf(MyScreens.Overview) }
        Scaffold(
            topBar = {
                MyTabRow(
                    allScreens = allScreens,
                    onTabSelected = { screen -> currentScreen = screen },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            Box(Modifier.padding(innerPadding)) {
                currentScreen.content(
                    onScreenChange = { screen1 ->
                        currentScreen = MyScreens.valueOf(screen1)
                    }
                )
            }
        }
    }
}


