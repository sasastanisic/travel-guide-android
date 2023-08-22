package rs.ac.metropolitan.view.screen.travel_detail_screen

import rs.ac.metropolitan.domain.model.Travel

data class TravelState(
    var travel: Travel = Travel(0, "", "", "", 0.0f, "")
)