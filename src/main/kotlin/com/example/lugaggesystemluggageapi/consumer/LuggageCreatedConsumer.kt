package com.example.lugaggesystemluggageapi.consumer

import com.example.lugaggesystemluggageapi.client.dto.response.customer.CustomerAPI
import com.example.lugaggesystemluggageapi.domain.event.LuggageCreatedEvent
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class LuggageCreatedConsumer(private val customerAPI: CustomerAPI) {


    @KafkaListener(topicPattern = "luggageCreated", groupId = "luggageCreated")
    suspend fun receive(payload: LuggageCreatedEvent) {
        val customer = payload.customerId?.let { customerAPI.getCustomerById(it) } ?: throw RuntimeException("Customer didnt found")
        println(customer.id)
    }
}