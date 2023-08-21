package rs.ac.metropolitan.view.screen.all_travels_screen

import rs.ac.metropolitan.domain.model.Travel

data class TravelsState(
    val travels: List<Travel> = emptyList()
)