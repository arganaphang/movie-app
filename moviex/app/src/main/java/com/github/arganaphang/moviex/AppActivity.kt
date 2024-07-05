package com.github.arganaphang.moviex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.github.arganaphang.moviex.ui.theme.MoviexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppScreen()
        }
    }
}

@Composable
fun AppScreen() {
    MoviexTheme {
        val navController = rememberNavController()
        AppNavGraph(navController)
    }
}

@Preview
@Composable
fun AppScreenPreview() {
    AppScreen()
}