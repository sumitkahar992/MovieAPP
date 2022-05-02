package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.home.DetailsScreen
import com.example.movieapp.screens.home.HomeSCreen


@Composable
fun Movienavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
          startDestination =  MovieScreens.HomeScreen.name) {


        //www.google.com/details-screen/id=34
        composable(MovieScreens.HomeScreen.name){
            HomeSCreen(navController = navController)
        }
        composable(MovieScreens.DetailsScreen.name+"/{movie}",
        arguments = listOf(navArgument(name = "movies"){type = NavType.StringType})){
            backStackEntry ->

             DetailsScreen(navController = navController,backStackEntry.arguments?.getString("movie"))
        }
    }
}