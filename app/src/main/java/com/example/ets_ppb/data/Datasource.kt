package com.example.ets_ppb.data

import com.example.ets_ppb.model.Ticket

class Datasource() {
    fun loadTickets(): List<Ticket> {
        return listOf<Ticket>(
            Ticket(80, 70000),
            Ticket(30, 200000),
            Ticket(100, 65000),
            Ticket(300, 20000),
            Ticket(70, 85000),
            Ticket(60, 120000),
            Ticket(65, 100000),
            Ticket(120, 50000),
        )
    }
}