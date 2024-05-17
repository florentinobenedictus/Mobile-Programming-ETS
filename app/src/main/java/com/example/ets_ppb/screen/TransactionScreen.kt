package com.example.ets_ppb.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ets_ppb.R
import com.example.ets_ppb.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionScreen(navController: NavController, email: String, srcCity: String, dstCity: String, selectedDate: String, selectedTime: String, arrivalTime: String, selectedSeat: String, passengerName: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Transaksi Berhasil!",
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.icon_checkmark),
            contentDescription = "Checkmark",
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .aspectRatio(1f)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
        ) {
            Column {
                Text(text = "Email                  : $email")
                Text(text = "Source City        : $srcCity")
                Text(text = "Destination City : $dstCity")
                Text(text = "Selected Date    : $selectedDate")
                Text(text = "Selected Time    : $selectedTime")
                Text(text = "Arrival Time       : $arrivalTime")
                Text(text = "Selected Seat     : $selectedSeat")
                Text(text = "Passenger Name : $passengerName")
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_download),
                contentDescription = "Download",
                modifier = Modifier.size(36.dp)
            )
            Text(
                text = "Download Ticket",
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }



    // Button
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = {
                navController.navigate(Screen.BookingScreen.withArgs(email))
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFC4B255))
        ) {
            Text(text = "Kembali")
        }
    }
}