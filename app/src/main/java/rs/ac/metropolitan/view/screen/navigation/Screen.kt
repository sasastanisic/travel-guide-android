package rs.ac.metropolitan.view.screen.navigation

sealed class Screen(val route: String) {

    object AllTravelsScreen : Screen("all_travels_screen")
    object NewTravelScreen : Screen("new_travel_screen")
    object TravelDetailScreen : Screen("travel_detail_screen")

}