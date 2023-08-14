package com.example.lugaggesystemluggageapi.domain.event

import java.util.UUID

data class LuggageCreatedEvent(
    val luggageId: UUID?,val customerId :UUID?
)
