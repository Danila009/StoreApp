package com.example.feature_authorization.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core_navigation.NiaNavigationDestination
import com.example.feature_authorization.screen.AuthorizationScreen
import com.example.feature_authorization.viewModel.AuthorizationViewModel

object AuthorizationDestination : NiaNavigationDestination {
    override val route = "authorization_route"
}

@ExperimentalAnimationApi
fun NavGraphBuilder.authorizationNavigation(
    authorizationViewModel:AuthorizationViewModel
) {
    composable(
        route = AuthorizationDestination.route
    ){
        AuthorizationScreen(
            viewModel = authorizationViewModel
        )
    }
}