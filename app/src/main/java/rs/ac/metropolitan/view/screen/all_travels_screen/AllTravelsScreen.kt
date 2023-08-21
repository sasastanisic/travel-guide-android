package rs.ac.metropolitan.view.screen.all_travels_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import rs.ac.metropolitan.domain.model.Travel
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
            items(travelsState.travels) { travel ->
                TravelCardView(travel = travel) {
                    navController.navigate(Screen.TravelDetailScreen.route + "/${travel.id}")
                }
            }
        }
    }

}

@Composable
fun TravelCardView(travel: Travel, onItemClick: (Travel) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 2.dp)
            .clickable { onItemClick(travel) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = "${travel.name}, ${travel.country}",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}