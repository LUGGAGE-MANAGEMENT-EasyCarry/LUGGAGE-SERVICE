package com.example.lugaggesystemluggageapi.producer

import com.example.lugaggesystemluggageapi.domain.event.LuggageCreatedEvent
import com.example.lugaggesystemluggageapi.domain.event.LuggageStateChangedEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class LuggageStateChangedEventProducer(private val kafkaTemplate: KafkaTemplate<String, LuggageStateChangedEvent>) {

    suspend fun send(payload: LuggageStateChangedEvent) {
        val topic ="luggageStateChanged"
        kafkaTemplate.send(topic,payload)
    }
}