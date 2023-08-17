package com.example.lugaggesystemluggageapi.domain.dto.request

import com.example.lugaggesystemluggageapi.domain.enums.State
import java.util.UUID

data class LuggageRequest(val luggageId: UUID? = null, val weight: Float, val flightId: UUID, val customerId: UUID, val state: State)
