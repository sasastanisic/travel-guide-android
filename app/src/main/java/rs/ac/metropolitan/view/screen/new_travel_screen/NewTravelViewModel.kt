package rs.ac.metropolitan.view.screen.new_travel_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import rs.ac.metropolitan.domain.model.Travel
import rs.ac.metropolitan.domain.service.UpsertTravel
import javax.inject.Inject

@HiltViewModel
class NewTravelViewModel @Inject constructor(
    private val upsertTravel: UpsertTravel
) : ViewModel() {

    fun createTravel(travel: Travel) {
        viewModelScope.launch {
            upsertTravel(travel)
        }
    }

}