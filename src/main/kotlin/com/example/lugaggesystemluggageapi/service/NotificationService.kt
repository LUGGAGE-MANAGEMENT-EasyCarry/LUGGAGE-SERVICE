package com.example.lugaggesystemluggageapi.service

import com.example.lugaggesystemluggageapi.client.dto.response.notification.EmailRequest
import com.example.lugaggesystemluggageapi.client.dto.response.notification.NotificationAPI
import com.example.lugaggesystemluggageapi.client.dto.response.notification.dto.NotificationRequest
import com.example.lugaggesystemluggageapi.client.dto.response.notification.dto.NotificationResponse
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import java.util.UUID

@Service
class NotificationService(private val notificationAPI: NotificationAPI) {

    suspend fun create(notificationRequest: NotificationRequest): NotificationResponse {
        return notificationAPI.create(notificationRequest)
    }

    suspend fun delete(@PathVariable id: UUID) {
        notificationAPI.delete(id)
    }

    suspend fun sendMail(emailRequest: EmailRequest) {
        notificationAPI.sendMail(emailRequest)
    }


}