package com.example.lugaggesystemluggageapi.producer

import com.example.lugaggesystemluggageapi.client.dto.response.notification.NotificationAPI
import com.example.lugaggesystemluggageapi.domain.event.LuggageCreatedEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class LuggageCreatedEventProducer(private val kafkaTemplate: KafkaTemplate<String, LuggageCreatedEvent>) {

    suspend fun send(@Payload payload: LuggageCreatedEvent) {

        val topic ="luggageCreated"
        kafkaTemplate.send(topic,payload)

    }
}