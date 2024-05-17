package com.example.ets_ppb.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ets_ppb.R
import com.example.ets_ppb.Screen
import com.example.ets_ppb.data.Datasource
import com.example.ets_ppb.model.Ticket
import javax.sql.DataSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicketScreen(navController: NavController, email: String, srcCity: String, dstCity: String, selectedDate: String, selectedTime: String){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Pilih Tiket",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFC4B255),
            ),
        )

        Spacer(modifier = Modifier.height(32.dp))

        TicketList(
            ticketList = Datasource().loadTickets(),
            navController = navController,
            email = email,
            srcCity = srcCity,
            dstCity = dstCity,
            selectedDate = selectedDate,
            selectedTime = selectedTime
        )

    }
}

@Composable
fun TicketCard(ticket: Ticket, navController: NavController, email: String, srcCity: String, dstCity: String, selectedDate: String, selectedTime: String, modifier: Modifier = Modifier) {
    val arrivalTime = addDurationToTime(selectedTime, ticket.duration)
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF5F6368),
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .width(60.dp)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = selectedTime,
                        style = TextStyle(color = Color.White),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = srcCity,
                    style = TextStyle(color = Color.White)
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { navController.navigate(Screen.SeatScreen.withArgs(email, srcCity, dstCity, selectedDate, selectedTime, arrivalTime)) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFC4B255),
                        contentColor = Color.White
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(text = "Pilih")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .width(60.dp)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = arrivalTime,
                        style = TextStyle(color = Color.White),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = dstCity,
                    style = TextStyle(color = Color.White)
                )
                Spacer(modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Rp. ${ticket.price}",
                    style = TextStyle(color = Color.White)
                )
            }
        }
    }
}

fun addDurationToTime(time: String, duration: Int): String {
    val (hours, minutes) = time.split(":").map { it.toInt() }

    val totalMinutes = hours * 60 + minutes + duration
    val newHours = (totalMinutes / 60) % 24
    val newMinutes = totalMinutes % 60

    return String.format("%02d:%02d", newHours, newMinutes)
}

@Composable
fun TicketList(ticketList: List<Ticket>, navController: NavController, email: String, srcCity: String, dstCity: String, selectedDate: String, selectedTime: String, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(ticketList) { ticket ->
            TicketCard(
                ticket = ticket,
                navController = navController,
                email = email,
                srcCity = srcCity,
                dstCity = dstCity,
                selectedDate = selectedDate,
                selectedTime = selectedTime,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}