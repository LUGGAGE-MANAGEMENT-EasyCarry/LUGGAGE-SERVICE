package com.example.lugaggesystemluggageapi.consumer


import com.example.lugaggesystemluggageapi.client.dto.response.notification.EmailRequest
import com.example.lugaggesystemluggageapi.domain.event.LuggageStateChangedEvent
import com.example.lugaggesystemluggageapi.service.NotificationService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class LuggageStateChangedConsumer(private val notificationAPI: NotificationService) {


    @KafkaListener(topicPattern = "luggageStateChanged", groupId = "luggageStateChanged")
    suspend fun receive(payload: LuggageStateChangedEvent) {
        notificationAPI.sendMail(EmailRequest("onboarding@resend.dev","190706015@st.maltepe.edu.tr"," State Changed to ${payload.state}",null))
    }
}