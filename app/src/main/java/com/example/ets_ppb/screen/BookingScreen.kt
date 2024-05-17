package com.example.ets_ppb.screen

import androidx.compose.material3.Icon
import android.util.Log
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ets_ppb.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.ets_ppb.Screen
import java.util.Calendar
import android.app.DatePickerDialog
import android.app.TimePickerDialog


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(navController: NavController, email: String) {
    val srcCities = listOf("Surabaya", "Bandung", "Jakarta", "Yogyakarta", "Semarang")
    val dstCities = listOf("Sidoarjo", "Gresik", "Mojokerto", "Lamongan", "Bangkalan")
    var srcExpanded by rememberSaveable { mutableStateOf(false) }
    var dstExpanded by rememberSaveable { mutableStateOf(false) }

    var srcCity by rememberSaveable {
        mutableStateOf("Surabaya")
    }

    var dstCity by rememberSaveable {
        mutableStateOf("Sidoarjo")
    }

    var selectedDate by rememberSaveable { mutableStateOf("") }
    var selectedTime by rememberSaveable { mutableStateOf("") }
    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Booking",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFC4B255),
            ),
        )

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Welcome $email!",
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {

            // From
            Text(text = "From")
            ExposedDropdownMenuBox(
                expanded = srcExpanded,
                onExpandedChange = {
                    srcExpanded = !srcExpanded
                }
            ) {
                TextField(
                    value = srcCity,
                    onValueChange = { srcCity = it },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_car),
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    readOnly = true,
                    label = { Text(text = "From") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = srcExpanded)
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors()
                )

                ExposedDropdownMenu(
                    expanded = srcExpanded,
                    onDismissRequest = {
                        srcExpanded = false
                    }
                ) {
                    srcCities.forEach { city ->
                        DropdownMenuItem(
                            text = { Text(text = city) },
                            onClick = {
                                srcCity = city
                                srcExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // To
            Text(text = "To")
            ExposedDropdownMenuBox(
                expanded = dstExpanded,
                onExpandedChange = {
                    dstExpanded = !dstExpanded
                }
            ) {
                TextField(
                    value = dstCity,
                    onValueChange = { dstCity = it },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_car),
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    readOnly = true,
                    label = { Text(text = "To") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = dstExpanded)
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors()
                )

                ExposedDropdownMenu(
                    expanded = dstExpanded,
                    onDismissRequest = {
                        dstExpanded = false
                    }
                ) {
                    dstCities.forEach { city ->
                        DropdownMenuItem(
                            text = { Text(text = city) },
                            onClick = {
                                dstCity = city
                                dstExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Departure Date
            val datePickerDialog = DatePickerDialog(
                LocalContext.current,
                { _, year, month, dayOfMonth ->
                    selectedDate = "$dayOfMonth-${month + 1}-$year"
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )

            Column {
                Text(text = "Departure Date")
                TextField(
                    value = selectedDate,
                    onValueChange = { },
                    readOnly = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = null,
                            modifier = Modifier.clickable(
                                onClick = { datePickerDialog.show() })
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Time
            val timePickerDialog = TimePickerDialog(
                LocalContext.current,
                { _, hourOfDay, minute ->
                    selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            )

            Column {
                Text(text = "Time")
                TextField(
                    value = selectedTime,
                    onValueChange = { },
                    readOnly = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_clock),
                            contentDescription = null,
                            modifier = Modifier.clickable(
                                onClick = { timePickerDialog.show() })
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
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
                navController.navigate(Screen.TicketScreen.withArgs(email, srcCity, dstCity, selectedDate, selectedTime))
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFC4B255))
        ) {
            Text(text = "Search")
        }
    }
}