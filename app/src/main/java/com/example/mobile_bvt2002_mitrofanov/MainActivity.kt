package com.example.mobile_bvt2002_mitrofanov

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.mobile_bvt2002_mitrofanov.navigation.NavHostInit
import com.example.mobile_bvt2002_mitrofanov.ui.theme.MobileBVT2002MitrofanovTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val splash = installSplashScreen()

//        setTheme(R.style.Theme_MobileBVT2002Mitrofanov)


//        splash.setKeepOnScreenCondition {
//            true
//        }

        setContent {

            MobileBVT2002MitrofanovTheme {
                // A surface container using the 'background' color from the theme
                Box(modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars).fillMaxSize()) {
                    NavHostInit()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello, $name!",
        modifier = modifier,
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileBVT2002MitrofanovTheme {
        Greeting("Android")
    }
}