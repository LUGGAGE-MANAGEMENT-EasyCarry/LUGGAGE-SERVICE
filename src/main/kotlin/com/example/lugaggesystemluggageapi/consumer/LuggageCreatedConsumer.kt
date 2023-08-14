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

    val logger = LoggerFactory.getLogger(LuggageCreatedEvent::class.java)

    @KafkaListener(topicPattern = "luggageCreated", groupId = "luggageCreated")
    fun receive(@Payload payload: LuggageCreatedEvent) {
        runBlocking {
            val customer = customerAPI.getCustomerById(
              payload.customerId!!
            )
            logger.info("this luggage is belongs to this customer: ${customer.name} ")

        }
    }
}