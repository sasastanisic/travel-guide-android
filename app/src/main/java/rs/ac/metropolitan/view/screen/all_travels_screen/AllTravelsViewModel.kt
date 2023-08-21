package rs.ac.metropolitan.view.screen.all_travels_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import rs.ac.metropolitan.domain.service.GetAllTravels
import javax.inject.Inject

@HiltViewModel
class AllTravelsViewModel @Inject constructor(
    private val getAllTravels: GetAllTravels
) : ViewModel() {

    private val _allTravelsState = mutableStateOf(TravelsState())
    val allTravelsState: State<TravelsState> = _allTravelsState

    private var getAllTravelsJob: Job? = null

    init {
        getTravels()
    }

    private fun getTravels() {
        getAllTravelsJob?.cancel()
        getAllTravelsJob = getAllTravels()
            .onEach { travels ->
                _allTravelsState.value = allTravelsState.value.copy(
                    travels = travels
                )
            }
            .launchIn(viewModelScope)
    }

}