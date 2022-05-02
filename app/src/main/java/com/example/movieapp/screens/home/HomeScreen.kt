package com.example.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.MovieRow
import com.example.movieapp.navigation.MovieScreens

@Composable
fun HomeSCreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Magenta,
            elevation = 5.dp) {
            Text(text = "Movies")
        }
    }) {
       MainContent(navController = navController)
    }

}


@Composable
fun MainContent(
    navController: NavController,
    moviesList: List<String> = listOf(
    "AVatar",
    "8848",
    "Avengers",
    "END",
    "LIFE",
    "Vodka",
    "DArk WEB",
    "Deep",
    "MIA",
    "Khalifa",
    "TT",
    "Table Tennis"
)){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = moviesList){

                MovieRow(movie = it){ movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                    //Log.d("TAG", "MainContent: $movie")
                }

            }
        }
    }
}