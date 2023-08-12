package com.example.lugaggesystemluggageapi.client.dto.response.notification

import com.example.lugaggesystemluggageapi.client.dto.response.notification.dto.EmailResponse
import com.example.lugaggesystemluggageapi.client.dto.response.notification.dto.NotificationRequest
import com.example.lugaggesystemluggageapi.client.dto.response.notification.dto.NotificationResponse
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import java.util.UUID
@Component
class NotificationAPI(private val notificationClient: WebClient) {

    suspend fun create(notificationRequest: NotificationRequest): NotificationResponse {
        return notificationClient.post().uri {
            it.path("api/notifications").build()
        }.bodyValue(notificationRequest).retrieve().awaitBody()
    }

    fun delete(@PathVariable id: UUID) {
        notificationClient.delete().uri {
            it.path("api/notifications/{id}").build(id)
        }
    }

    suspend fun sendMail(emailRequest: EmailRequest): EmailResponse {
        return notificationClient.post().uri {
            it.path("api/notifications/sendmail").build()
        }.bodyValue(emailRequest).retrieve().awaitBody()
    }

}