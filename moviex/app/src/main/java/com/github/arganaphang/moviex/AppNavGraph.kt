package com.github.arganaphang.moviex

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.github.arganaphang.moviex.screen.detail.DetailScreen
import com.github.arganaphang.moviex.screen.main.BookmarkScreen
import com.github.arganaphang.moviex.screen.main.HomeScreen
import kotlinx.serialization.Serializable

@Composable
fun AppNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = AppRoutes.Main) {
        // TODO: MainScreen() buat bottom navigation bar nya ga kepake kalau pake cara ini
        navigation<AppRoutes.Main>(startDestination = AppRoutes.Main.Home) {
            composable<AppRoutes.Main.Home> {
                HomeScreen()
            }
            composable<AppRoutes.Main.Bookmark> {
                BookmarkScreen()
            }
        }
        composable<AppRoutes.Detail> {
            DetailScreen()
        }
    }
}


object AppRoutes {
    @Serializable
    object Main {
        @Serializable
        object Home

        @Serializable
        object Bookmark
    }

    @Serializable
    data class Detail(val id: Int)
}
