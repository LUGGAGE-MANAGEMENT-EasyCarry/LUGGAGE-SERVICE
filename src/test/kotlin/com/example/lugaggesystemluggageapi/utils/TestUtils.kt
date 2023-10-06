/*package com.example.lugaggesystemluggageapi.utils

import com.example.lugaggesystemluggageapi.domain.dto.request.LuggageRequest
import com.example.lugaggesystemluggageapi.domain.dto.request.response.LuggageResponse
import com.example.lugaggesystemluggageapi.domain.enums.State
import com.example.lugaggesystemluggageapi.domain.event.LuggageCreatedEvent
import com.example.lugaggesystemluggageapi.domain.model.Luggage
import java.util.UUID


fun getLuggage(
    luggageId: UUID? = UUID.fromString("3a6c0bd2-25e9-48d1-8469-72cf3600aebc"),
    weight: Float = 72.2f,
    flightId: UUID = UUID.fromString("3d21c322-5b16-4b3a-9f51-11670c625a72"),
    customerId: UUID = UUID.fromString("a965b9ae-0288-4682-b75a-1b292e601f60")
) = Luggage(
    luggageId, weight, flightId, customerId
)


fun createLuggageRequest(
    luggageId: UUID? = UUID.fromString("3a6c0bd2-25e9-48d1-8469-72cf3600aebc"),
    weight: Float = 72.2f,
    flightId: UUID = UUID.fromString("3d21c322-5b16-4b3a-9f51-11670c625a72"),
    customerId: UUID = UUID.fromString("a965b9ae-0288-4682-b75a-1b292e601f60")
) = Luggage(
    luggageId, weight, flightId, customerId
)

fun getLuggageCreatedEvent(
    luggageId: UUID? = UUID.fromString("3a6c0bd2-25e9-48d1-8469-72cf3600aebc")
) = LuggageCreatedEvent(luggageId, null)

fun getluggageResponse(
    luggageId: UUID? = UUID.fromString("3a6c0bd2-25e9-48d1-8469-72cf3600aebc"),
    weight: Float = 72.2f,
    flightId: UUID = UUID.fromString("3d21c322-5b16-4b3a-9f51-11670c625a72"),
    customerId: UUID = UUID.fromString("3d21c322-5b16-4b3a-9f51-11670c625a72"), state: State = State.CHECK_IN
) = LuggageResponse(luggageId, weight, flightId, customerId, state)

fun setLuggageState(
    luggageId: UUID? = UUID.fromString("3a6c0bd2-25e9-48d1-8469-72cf3600aebc"),
    weight: Float = 72.2f,
    flightId: UUID = UUID.fromString("3d21c322-5b16-4b3a-9f51-11670c625a72"),
    customerId: UUID = UUID.fromString("3d21c322-5b16-4b3a-9f51-11670c625a72"),
    state: State = State.PENDING
) = Luggage(luggageId ,weight,flightId,customerId,state)*/

