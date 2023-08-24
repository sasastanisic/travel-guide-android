package rs.ac.metropolitan.view.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import rs.ac.metropolitan.common.Constants
import rs.ac.metropolitan.view.screen.all_travels_screen.AllTravelsScreen
import rs.ac.metropolitan.view.screen.new_travel_screen.NewTravelScreen
import rs.ac.metropolitan.view.screen.travel_detail_screen.TravelDetailScreen
import rs.ac.metropolitan.view.screen.welcome_screen.WelcomeScreen

@Composable
fun NavSetup(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route) {
        composable(route = Screen.WelcomeScreen.route) {
            WelcomeScreen(navController)
        }

        composable(route = Screen.AllTravelsScreen.route) {
            AllTravelsScreen(navController)
        }

        composable(route = Screen.TravelDetailScreen.route + "/{${Constants.PARAM_TRAVEL_ID}}") {
            TravelDetailScreen(navController)
        }

        composable(route = Screen.NewTravelScreen.route) {
            NewTravelScreen(navController)
        }
    }

}