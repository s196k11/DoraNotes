package com.example.doranotes.Screens.MainScreen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.doranotes.MainViewModel.MainViewModel
import com.example.doranotes.Navigation.NavRoutes
import com.example.doranotes.Screens.AddNote.AddNote
import com.example.doranotes.Screens.DisplayNote.DisplayNote
import com.example.doranotes.Screens.EditNote.EditNote
import com.example.doranotes.Screens.HomeScreen.HomeScreen
import com.example.doranotes.Screens.SplashScreen.SplashScreen

@Composable
fun MainScreen(viewModel: MainViewModel){

    val navcontroller = rememberNavController()

    NavHost(navController = navcontroller,
        startDestination = NavRoutes.HomeScreen.route ){

//        composable(route = NavRoutes.SplashScreen.route){
//            SplashScreen()
//        }

        composable(route = NavRoutes.HomeScreen.route){
            HomeScreen(viewModel = viewModel,navHostController = navcontroller)
        }

        composable(route = NavRoutes.AddNote.route){
            AddNote(mainViewModel = viewModel, navHostController = navcontroller)
        }

        composable(route = NavRoutes.DisplayNote.route){
            DisplayNote()
        }

        composable(route = NavRoutes.EditNote.route){
            EditNote()
        }
    }
}