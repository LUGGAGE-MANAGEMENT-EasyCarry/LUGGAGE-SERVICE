package com.example.lugaggesystemluggageapi.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "luggage")
 class Luggage(

        @Id
        @GeneratedValue
        val luggageId: UUID? = null,

        val weight: Float,

        @Column(name = "flight_id")
        val flightId: UUID,
        @Column(name = "customer_id")
        val customerId: UUID, var state: String,

        @Column(name = "checkin_id")
        val checkInId: UUID? = null

 )
