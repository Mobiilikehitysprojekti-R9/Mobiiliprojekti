package com.example.mobiiliprojektir9

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.driverssite.DriverSite

/*
NAVIGAATION NÄYTETTÄVIEN SIVUJEN MÄÄRITYS
Annetaan Screens luokasta route ja sen jälkeen sivu, joka halutaan avata annetulla routella
Jos sivulta täytyy päästä vielä eteenpäin toiselle sivulle, välitetään sille navController
Esim. LoginPagessa: onClick = { navcontroller.navigate(Screens.RegisterAs.route) }
HUOM! Jotta navigaatio toimii, täytyy "sivu" olla composable funktio. Luokan kutsu ei toimi.
*/

@Composable
fun SetUpNavigation(navController : NavHostController) {
    NavHost(navController = navController, startDestination = "login_screen")
    {
        composable(
            route = Screens.Login.route
        ){
            Login(navController = navController)
        }
        composable(
            route = Screens.RegisterAs.route
        ){
            RegisterAs(navController = navController)
        }
        composable(
            route = Screens.RegisterDriver.route
        ){
            RegisterDriver(navController = navController)
        }
        composable(
            route = Screens.RegisterOrganizer.route
        ){
            RegisterCoordinator(navController = navController)
        }
        composable(
            route = Screens.DriverSite.route + "/{userId}",
        ) { backStackEntry ->
            DriverSite(navController = navController, backStackEntry.arguments?.getString("userId"))
        }
        composable(
            route = Screens.CreateJob.route + "/{userId}",
        ) { backStackEntry ->
            CreateJob(navController = navController, backStackEntry.arguments?.getString("userId"))
        }
    }
}