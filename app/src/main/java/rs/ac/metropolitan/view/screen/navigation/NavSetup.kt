package rs.ac.metropolitan.view.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import rs.ac.metropolitan.common.Constants
import rs.ac.metropolitan.view.screen.all_travels_screen.AllTravelsScreen
import rs.ac.metropolitan.view.screen.new_travel_screen.NewTravelScreen

@Composable
fun NavSetup(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.AllTravelsScreen.route) {
        composable(route = Screen.AllTravelsScreen.route) {
            AllTravelsScreen(navController)
        }

        composable(route = Screen.TravelDetailScreen.route + "/{${Constants.PARAM_TRAVEL_ID}}") {

        }

        composable(route = Screen.NewTravelScreen.route) {
            NewTravelScreen(navController)
        }
    }

}