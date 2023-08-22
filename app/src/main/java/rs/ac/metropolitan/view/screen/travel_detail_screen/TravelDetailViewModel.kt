package rs.ac.metropolitan.view.screen.travel_detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import rs.ac.metropolitan.common.Constants
import rs.ac.metropolitan.domain.model.Travel
import rs.ac.metropolitan.domain.service.DeleteTravel
import rs.ac.metropolitan.domain.service.GetTravel
import javax.inject.Inject

@HiltViewModel
class TravelDetailViewModel @Inject constructor(
    private val getTravel: GetTravel,
    private val deleteTravel: DeleteTravel,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _travelState = mutableStateOf(TravelState())
    val travelState: State<TravelState> = _travelState

    init {
        viewModelScope.launch {
            savedStateHandle.get<String>(Constants.PARAM_TRAVEL_ID)?.let { id ->
                getTravelById(id.toInt())
            }
        }
    }

    private suspend fun getTravelById(id: Int) {
        getTravel(id)?.let { travel ->
            _travelState.value.travel = travel
        }
    }

    fun removeTravel(travel: Travel) {
        viewModelScope.launch {
            deleteTravel(travel)
        }
    }

}