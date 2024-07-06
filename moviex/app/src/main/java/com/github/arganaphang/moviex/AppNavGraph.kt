package com.github.arganaphang.moviex

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import com.github.arganaphang.moviex.screen.detail.DetailScreen
import com.github.arganaphang.moviex.screen.main.BookmarkScreen
import com.github.arganaphang.moviex.screen.main.HomeScreen
import kotlinx.serialization.Serializable

@Composable
fun AppNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Routes.Main.route,
        ) {
        navigation(route = Routes.Main.route, startDestination = Routes.Main.Home.route) {
            composable(route = Routes.Main.Home.route) {
                HomeScreen(onNavigateToDetail = { id ->
                    navHostController.navigate(Routes.Detail(id))
                })
            }
            composable(route = Routes.Main.Bookmark.route) {
                BookmarkScreen(onNavigateToDetail = { id ->
                    navHostController.navigate(Routes.Detail(id))
                })
            }
        }
        composable<Routes.Detail> { backStackEntry ->
            val id: Int = backStackEntry.toRoute<Routes.Detail>().id
            DetailScreen(id)
        }
    }
}


@Serializable
sealed class Routes(val route: String) {
    @Serializable
    data object Main : Routes("main") {
        @Serializable
        data object Home : Routes("main/home")

        @Serializable
        data object Bookmark : Routes("main/bookmark")
    }

    @Serializable
    data class Detail(val id: Int)
}
