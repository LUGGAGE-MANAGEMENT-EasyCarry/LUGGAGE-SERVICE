package com.example.lugaggesystemluggageapi.domain.event

import java.util.UUID

data class LuggageCreatedEvent(
    val luggageId: UUID?=null,val customerId :UUID?=null
)
