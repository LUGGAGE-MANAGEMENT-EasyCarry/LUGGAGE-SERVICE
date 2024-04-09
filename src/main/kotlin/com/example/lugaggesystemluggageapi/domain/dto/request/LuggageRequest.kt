package com.example.lugaggesystemluggageapi.domain.dto.request

import java.util.UUID

data class LuggageRequest
( val weight: Float,
  val flightId: UUID,
  val customerId: UUID,
  val state: String,
  val checkInId:UUID)
