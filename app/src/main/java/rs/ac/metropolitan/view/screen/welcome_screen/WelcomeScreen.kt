package rs.ac.metropolitan.view.screen.welcome_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import rs.ac.metropolitan.R
import rs.ac.metropolitan.view.screen.navigation.Screen

@Composable
fun WelcomeScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Travel Guide",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black,
                modifier = Modifier.padding(8.dp),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = R.drawable.travel_icon),
                contentDescription = "Travel icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(350.dp)
                    .padding(8.dp)
            )
        }
        Button(
            onClick = { navController.navigate(Screen.AllTravelsScreen.route) },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "WELCOME",
                color = Color.White,
                fontSize = 19.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }

}