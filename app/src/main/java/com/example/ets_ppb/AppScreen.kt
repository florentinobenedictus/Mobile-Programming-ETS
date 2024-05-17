package com.example.ets_ppb

import android.util.Log
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ets_ppb.screen.BookingScreen
import com.example.ets_ppb.screen.LoginScreen
import com.example.ets_ppb.screen.RegisterScreen
import com.example.ets_ppb.screen.SeatScreen
import com.example.ets_ppb.screen.TicketScreen
import com.example.ets_ppb.screen.TransactionScreen

@Composable
fun AppScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(
            route = Screen.BookingScreen.route + "/{email}",
            arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                }
            )
            ) { entry ->
            val email = entry.arguments?.getString("email") ?: ""
            BookingScreen(
                navController = navController,
                email = email
            )
        }
        composable(
            route = Screen.TicketScreen.route + "/{email}" + "/{srcCity}" + "/{dstCity}" + "/{selectedDate}" + "/{selectedTime}",
            arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                },
                navArgument("srcCity") {
                    type = NavType.StringType
                },
                navArgument("dstCity") {
                    type = NavType.StringType
                },
                navArgument("selectedDate") {
                    type = NavType.StringType
                },
                navArgument("selectedTime") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val email = entry.arguments?.getString("email") ?: ""
            val srcCity = entry.arguments?.getString("srcCity") ?: ""
            val dstCity = entry.arguments?.getString("dstCity") ?: ""
            val selectedDate = entry.arguments?.getString("selectedDate") ?: ""
            val selectedTime = entry.arguments?.getString("selectedTime") ?: ""

            TicketScreen(
                navController = navController,
                email = email,
                srcCity = srcCity,
                dstCity = dstCity,
                selectedDate = selectedDate,
                selectedTime = selectedTime
            )
        }
        composable(
            route = Screen.SeatScreen.route + "/{email}" + "/{srcCity}" + "/{dstCity}" + "/{selectedDate}" + "/{selectedTime}" + "/{arrivalTime}",
            arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                },
                navArgument("srcCity") {
                    type = NavType.StringType
                },
                navArgument("dstCity") {
                    type = NavType.StringType
                },
                navArgument("selectedDate") {
                    type = NavType.StringType
                },
                navArgument("selectedTime") {
                    type = NavType.StringType
                },
                navArgument("arrivalTime") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val email = entry.arguments?.getString("email") ?: ""
            val srcCity = entry.arguments?.getString("srcCity") ?: ""
            val dstCity = entry.arguments?.getString("dstCity") ?: ""
            val selectedDate = entry.arguments?.getString("selectedDate") ?: ""
            val selectedTime = entry.arguments?.getString("selectedTime") ?: ""
            val arrivalTime = entry.arguments?.getString("arrivalTime") ?: ""

            SeatScreen(
                navController = navController,
                email = email,
                srcCity = srcCity,
                dstCity = dstCity,
                selectedDate = selectedDate,
                selectedTime = selectedTime,
                arrivalTime = arrivalTime
            )
        }
        composable(
            route = Screen.TransactionScreen.route + "/{email}" + "/{srcCity}" + "/{dstCity}" + "/{selectedDate}" + "/{selectedTime}" + "/{arrivalTime}" + "/{selectedSeat}" + "/{passengerName}",
            arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                },
                navArgument("srcCity") {
                    type = NavType.StringType
                },
                navArgument("dstCity") {
                    type = NavType.StringType
                },
                navArgument("selectedDate") {
                    type = NavType.StringType
                },
                navArgument("selectedTime") {
                    type = NavType.StringType
                },
                navArgument("arrivalTime") {
                    type = NavType.StringType
                },
                navArgument("selectedSeat") {
                    type = NavType.StringType
                },
                navArgument("passengerName") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val email = entry.arguments?.getString("email") ?: ""
            val srcCity = entry.arguments?.getString("srcCity") ?: ""
            val dstCity = entry.arguments?.getString("dstCity") ?: ""
            val selectedDate = entry.arguments?.getString("selectedDate") ?: ""
            val selectedTime = entry.arguments?.getString("selectedTime") ?: ""
            val arrivalTime = entry.arguments?.getString("arrivalTime") ?: ""
            val selectedSeat = entry.arguments?.getString("selectedSeat") ?: ""
            val passengerName = entry.arguments?.getString("passengerName") ?: ""

            TransactionScreen(
                navController = navController,
                email = email,
                srcCity = srcCity,
                dstCity = dstCity,
                selectedDate = selectedDate,
                selectedTime = selectedTime,
                arrivalTime = arrivalTime,
                selectedSeat = selectedSeat,
                passengerName = passengerName
            )
        }
    }


}


