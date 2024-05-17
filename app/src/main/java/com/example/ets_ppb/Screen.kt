package com.example.ets_ppb

sealed class Screen(val route: String){
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")
    object BookingScreen: Screen("booking_screen")
    object TicketScreen: Screen("ticket_screen")
    object SeatScreen: Screen("seat_screen")
    object TransactionScreen: Screen("transaction_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}