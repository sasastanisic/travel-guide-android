package rs.ac.metropolitan.view.screen.new_travel_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import rs.ac.metropolitan.domain.model.Travel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTravelScreen(
    navController: NavController,
    viewModel: NewTravelViewModel = hiltViewModel()
) {

    var name by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(""))
    }
    var country by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(""))
    }
    var accommodation by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(""))
    }
    var budget by rememberSaveable {
        mutableStateOf(0.0)
    }
    var notes by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(""))
    }

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(10.dp)
        ) {
            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    IconButton(
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(1.5f),
                        onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Go back",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    Text(
                        text = "Create new travel",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            item {
                TextField(
                    value = name,
                    onValueChange = { value ->
                        name = value
                    },
                    placeholder = { Text("Enter name") }
                )
            }
            item {
                TextField(
                    value = country,
                    onValueChange = { value ->
                        country = value
                    },
                    placeholder = { Text("Enter country") }
                )
            }
            item {
                TextField(
                    value = accommodation,
                    onValueChange = { value ->
                        accommodation = value
                    },
                    placeholder = { Text("Enter accommodation") }
                )
            }
            item {
                Slider(
                    value = budget.toFloat(),
                    onValueChange = { value ->
                        budget = value.toDouble()
                    },
                    onValueChangeFinished = {},
                    valueRange = 50f..5000f,
                    steps = 100,
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.secondary,
                        activeTrackColor = MaterialTheme.colorScheme.tertiary
                    ),
                    modifier = Modifier.padding(horizontal = 30.dp)
                )
                Text("Expected budget %.1f".format(budget))
            }
            item {
                TextField(
                    value = notes,
                    onValueChange = { value ->
                        notes = value
                    },
                    placeholder = { Text("Enter notes about this place") }
                )
            }
            item {
                Button(onClick = {
                    viewModel.createTravel(
                        Travel(
                            id = 0,
                            name = name.text,
                            country = country.text,
                            accommodation = accommodation.text,
                            budget = budget.toFloat(),
                            notes = notes.text
                        )
                    )
                    navController.popBackStack()
                }) {
                    Text("Submit")
                }
            }
        }
    }

}