package com.example.lugaggesystemluggageapi.client.dto.response.notification.dto

import java.time.LocalDate
import java.util.UUID

data class NotificationResponse(val id: UUID? = null, val  createdAt: LocalDate, val info:String)