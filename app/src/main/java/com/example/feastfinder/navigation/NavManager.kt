package com.example.feastfinder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feastfinder.ui.theme.login.views.LoginScreen
import com.example.feastfinder.ui.theme.login.views.MenuApp
import com.example.feastfinder.viewmodel.LoginViewModel


@Composable
fun NavManager(loginVM: LoginViewModel){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "Home" ){
        composable("Home"){
            LoginScreen(loginVM,navController)
        }
        composable("Recetas"){
            MenuApp(navController)
        }

    }


}