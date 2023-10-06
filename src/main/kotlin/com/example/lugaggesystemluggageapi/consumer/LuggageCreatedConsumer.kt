package com.example.lugaggesystemluggageapi.consumer

import com.example.lugaggesystemluggageapi.client.dto.response.customer.CustomerAPI
import com.example.lugaggesystemluggageapi.client.dto.response.notification.EmailRequest
import com.example.lugaggesystemluggageapi.domain.event.LuggageCreatedEvent
import com.example.lugaggesystemluggageapi.service.NotificationService
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class LuggageCreatedConsumer(private val customerAPI: CustomerAPI,private val notificationAPI: NotificationService) {


    @KafkaListener(topicPattern = "luggageCreated", groupId = "luggageCreated")
    suspend fun receive(payload: LuggageCreatedEvent) {
        val customer = payload.customerId?.let { customerAPI.getCustomerById(it) } ?: throw RuntimeException("Customer didnt found")
        notificationAPI.sendMail(EmailRequest("onboarding@resend.dev","190706015@st.maltepe.edu.tr","Welcome  ${customer.name} the Our  EasyCarry  Family! ",null))
    }
}