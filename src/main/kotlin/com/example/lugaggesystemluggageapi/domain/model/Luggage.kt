package com.example.lugaggesystemluggageapi.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID
@Table(name = "luggage")
data class Luggage(@Id val luggageId : UUID?=null, val weight:Float, val flightId:UUID, val customerId:UUID,var state: String,val checkInId:UUID?=null)
