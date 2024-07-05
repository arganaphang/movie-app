package com.github.arganaphang.moviex.screen.main

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.github.arganaphang.moviex.AppRoutes


data class BottomNavItem(
    val title: String,
    val route: Any,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route = AppRoutes.Main.Home,
        selectedIcon = Icons.Rounded.Home,
        unselectedIcon = Icons.Outlined.Home,
    ),
    BottomNavItem(
        title = "Bookmark",
        route = AppRoutes.Main.Bookmark,
        selectedIcon = Icons.Rounded.Favorite,
        unselectedIcon = Icons.Rounded.FavoriteBorder,
    ),
)


@Composable
fun MainScreen() {
    var selectedIdx by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEachIndexed { index, bottomNavItem ->
                    NavigationBarItem(
                        selected = selectedIdx == index,
                        onClick = {
                            selectedIdx = index
                        },
                        icon = {
                            Icon(
                                imageVector = if (selectedIdx == index) bottomNavItem.selectedIcon else bottomNavItem.unselectedIcon,
                                contentDescription = null,
                            )
                        }
                    )
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
                Text("Main Screen")
            }
        }
    }
}