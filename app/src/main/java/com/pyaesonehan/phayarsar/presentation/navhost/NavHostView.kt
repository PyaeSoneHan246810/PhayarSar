package com.pyaesonehan.phayarsar.presentation.navhost

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.pyaesonehan.phayarsar.presentation.detail.DetailScreenView
import com.pyaesonehan.phayarsar.presentation.detail.DetailViewModel
import com.pyaesonehan.phayarsar.presentation.groups.GroupsScreenView
import com.pyaesonehan.phayarsar.presentation.groups.GroupsViewModel

@Composable
fun NavHostView(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier
            .fillMaxSize(),
        navController = navController,
        startDestination = Destination.GroupsScreen
    ) {
        composable<Destination.GroupsScreen> {
            val groupsViewModel: GroupsViewModel = viewModel(
                factory = GroupsViewModel.Factory
            )
            val groupsUiState by groupsViewModel.groupUiState.collectAsStateWithLifecycle()
            GroupsScreenView(
                groupsUiState = groupsUiState,
                onRetry = {
                    groupsViewModel.getGroups()
                },
                onItemClick = { groupId, detailId ->
                    val detailsScreen = Destination.DetailScreen(groupId, detailId)
                    navController.navigate(detailsScreen)
                }
            )
        }
        composable<Destination.DetailScreen> { backStackEntry ->
            val detailsScreen: Destination.DetailScreen = backStackEntry.toRoute()
            val groupId = detailsScreen.groupId
            val detailId = detailsScreen.detailId
            val detailViewModel: DetailViewModel = viewModel(
                factory = DetailViewModel.Factory
            )
            val detailUiState by detailViewModel.detailUiState.collectAsStateWithLifecycle()
            LaunchedEffect(groupId, detailId) {
                detailViewModel.getDetail(groupId, detailId)
            }
            DetailScreenView(
                detailUiState = detailUiState,
                onRetry = {
                    detailViewModel.getDetail(groupId, detailId)
                },
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}