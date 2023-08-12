package com.example.lugaggesystemluggageapi.domain.request

import com.example.lugaggesystemluggageapi.domain.enums.StateType
import java.util.UUID

data class LuggageRequest(val weight:Float, val flightId: UUID, val customerID: UUID, val stateType: StateType)
