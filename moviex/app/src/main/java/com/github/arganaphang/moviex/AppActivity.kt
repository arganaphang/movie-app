package com.github.arganaphang.moviex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
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


data class BottomNavItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route = Routes.Main.Home.route,
        selectedIcon = Icons.Rounded.Home,
        unselectedIcon = Icons.Outlined.Home,
    ),
    BottomNavItem(
        title = "Bookmark",
        route = Routes.Main.Bookmark.route,
        selectedIcon = Icons.Rounded.Favorite,
        unselectedIcon = Icons.Rounded.FavoriteBorder,
    ),
)

@Composable
fun AppScreen() {
    MoviexTheme {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry?.destination
                val bottomNavRoutes = bottomNavItems.map { it.route }
                when {
                    !bottomNavRoutes.any { it == currentRoute?.route } -> { return@Scaffold }
                }
                NavigationBar {
                    bottomNavItems.forEach { bottomNavItem ->
                        NavigationBarItem(
                            selected = bottomNavItem.route == currentRoute?.route,
                            onClick = {
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                Icon(
                                    imageVector = if (bottomNavItem.route == currentRoute?.route) {
                                        bottomNavItem.selectedIcon
                                    } else {
                                        bottomNavItem.unselectedIcon
                                    },
                                    contentDescription = null,
                                )
                            })
                    }
                }
            },
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    val backStackEntry by navController.currentBackStackEntryAsState()
                    Log.d("INI LOG", "AppScreen: " + backStackEntry?.destination?.route)
                    Log.d("INI LOG", "AppScreen: " + Routes.Main.Home.toString())
                    AppNavGraph(navController)
                }
            }
        }
    }
}

@Preview
@Composable
fun AppScreenPreview() {
    AppScreen()
}