package com.example.lugaggesystemluggageapi.domain.response

import com.example.lugaggesystemluggageapi.domain.enums.StateType
import java.util.UUID

data class LuggageResponse(val id : UUID?=null, val weight:Float, val flightId: UUID, val customerID: UUID, val stateType: StateType)