package com.example.ets_ppb.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ets_ppb.R
import com.example.ets_ppb.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeatScreen(navController: NavController, email: String, srcCity: String, dstCity: String, selectedDate: String, selectedTime: String, arrivalTime: String) {
    var selectedSeat by rememberSaveable {
        mutableStateOf("0")
    }
    var passengerName by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Pilih Kursi",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFC4B255),
            ),
        )

        Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Row 1
            Row(
                modifier = Modifier.padding(2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_seat),
                        contentDescription = "Seat Icon",
                        modifier = Modifier.size(48.dp),
                        colorFilter = ColorFilter.tint(Color.Green)
                    )
                    Text(
                        text = "1",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    RadioButton(
                        selected = selectedSeat == "1",
                        onClick = { selectedSeat = "1" },
                        colors = RadioButtonDefaults.colors(selectedColor = Color(0xFFC4B255))
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_driver),
                        contentDescription = "Driver Icon",
                        modifier = Modifier.size(48.dp)
                    )
                    Text(
                        text = "Driver",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }

            // Row 2
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.padding(2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier.size(64.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "pintu",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        modifier = Modifier.rotate(90f),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_seat),
                        contentDescription = "Seat Icon",
                        modifier = Modifier.size(48.dp),
                        colorFilter = ColorFilter.tint(Color.Green)
                    )
                    Text(
                        text = "2",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    RadioButton(
                        selected = selectedSeat == "2",
                        onClick = { selectedSeat = "2" },
                        colors = RadioButtonDefaults.colors(selectedColor = Color(0xFFC4B255))
                    )
                }
            }

            // Row 3
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.padding(2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_seat),
                        contentDescription = "Seat Icon",
                        modifier = Modifier.size(48.dp),
                        colorFilter = ColorFilter.tint(Color.Green)
                    )
                    Text(
                        text = "3",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    RadioButton(
                        selected = selectedSeat == "3",
                        onClick = { selectedSeat = "3" },
                        colors = RadioButtonDefaults.colors(selectedColor = Color(0xFFC4B255))
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_seat),
                        contentDescription = "Seat Icon",
                        modifier = Modifier.size(48.dp),
                        colorFilter = ColorFilter.tint(Color.Red)
                    )
                    Text(
                        text = "4",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }

            // Row 4
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.padding(2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_seat),
                        contentDescription = "Seat Icon",
                        modifier = Modifier.size(48.dp),
                        colorFilter = ColorFilter.tint(Color.Green)
                    )
                    Text(
                        text = "5",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    RadioButton(
                        selected = selectedSeat == "5",
                        onClick = { selectedSeat = "5" },
                        colors = RadioButtonDefaults.colors(selectedColor = Color(0xFFC4B255))
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_seat),
                        contentDescription = "Seat Icon",
                        modifier = Modifier.size(48.dp),
                        colorFilter = ColorFilter.tint(Color.Red)
                    )
                    Text(
                        text = "6",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_seat),
                        contentDescription = "Seat Icon",
                        modifier = Modifier.size(48.dp),
                        colorFilter = ColorFilter.tint(Color.Green)
                    )
                    Text(
                        text = "7",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    RadioButton(
                        selected = selectedSeat == "7",
                        onClick = { selectedSeat = "7" },
                        colors = RadioButtonDefaults.colors(selectedColor = Color(0xFFC4B255))
                    )
                }
            }
        }

        // Button
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(text = "Nama Penumpang")
            TextField(
                value = passengerName,
                onValueChange = { passengerName = it },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    navController.navigate(Screen.TransactionScreen.withArgs(email, srcCity, dstCity, selectedDate, selectedTime, arrivalTime, selectedSeat, passengerName))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFC4B255))
            ) {
                Text(text = "Pesan")
            }
        }
    }
}
