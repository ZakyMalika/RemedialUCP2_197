package com.example.remedjadu.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.remedjadu.view.*
import com.example.remedjadu.view.route.*

@Composable
fun BukuApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(navController = navController, modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {

        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToEntry = {
                    navController.navigate(DestinasiEntryBuku.route)
                },
                navigateToEdit = {
                    navController.navigate("${DestinasiDetailBuku.route}/$it")
                }
            )
        }

        composable(DestinasiEntryBuku.route) {
            EntryBukuScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(
            route = DestinasiDetailBuku.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiDetailBuku.itemIdArg) {
                    type = NavType.IntType
                }
            )
        ) {
            DetailBukuScreen(
                navigateToEdit = {
                    navController.navigate("${DestinasiEditBuku.route}/$it")
                },
                navigateBack = { navController.navigateUp() }
            )
        }

        composable(
            route = DestinasiEditBuku.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiEditBuku.itemIdArg) {
                    type = NavType.IntType
                }
            )
        ) {
            EditBukuScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}
