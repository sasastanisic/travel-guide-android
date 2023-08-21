package rs.ac.metropolitan.view.screen.all_travels_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import rs.ac.metropolitan.view.screen.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllTravelsScreen(
    navController: NavController,
    viewModel: AllTravelsViewModel = hiltViewModel()
) {

    val travelsState = viewModel.allTravelsState.value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.NewTravelScreen.route) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { paddingValue ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValue)
                .padding(horizontal = 20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(17.dp)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp)
                ) {
                    Text(
                        text = "Travel Guide",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }

}