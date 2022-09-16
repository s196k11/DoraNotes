package com.example.doranotes.Navigation

sealed class NavRoutes(val route:String){
    object SplashScreen:NavRoutes("splash_screen")
    object HomeScreen:NavRoutes("home_screen")
    object AddNote:NavRoutes("add_note")
    object DisplayNote : NavRoutes("display_Note")
    object EditNote:NavRoutes("edit_note")
}
