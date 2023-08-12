package com.example.lugaggesystemluggageapi.configuration.client


import com.example.lugaggesystemluggageapi.configuration.properties.NotificationAPIProperties
import com.example.lugaggesystemluggageapi.util.configureTimeouts
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class NotificationClientConfiguration {

    @Bean("notificationClient")
    fun notificationClient(notificationAPIProperties: NotificationAPIProperties) = with(notificationAPIProperties) {
        WebClient.builder().baseUrl(baseUrl).configureTimeouts(readTimeout, connectTimeout).build()
    }

}