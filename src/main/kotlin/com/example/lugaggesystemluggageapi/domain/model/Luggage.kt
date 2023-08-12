package com.example.lugaggesystemluggageapi.domain.model

import com.example.lugaggesystemluggageapi.domain.enums.State
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID
@Table(name = "luggage")
data class Luggage(@Id val luggageId : UUID?=null, val weight:Float, val flightId:UUID, val customerId:UUID,var state: State =State.PENDING)
