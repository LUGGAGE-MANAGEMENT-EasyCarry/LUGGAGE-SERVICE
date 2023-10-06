package com.example.lugaggesystemluggageapi.configuration.client


import com.example.lugaggesystemluggageapi.configuration.properties.CustomerAPIProperties
import com.example.lugaggesystemluggageapi.util.configureTimeouts
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class CustomerClientConfiguration {

    @Bean("customerClient")
    fun customerClient(customerAPIProperties: CustomerAPIProperties) = with(customerAPIProperties) {
        WebClient.builder().baseUrl(baseUrl).configureTimeouts(connectTimeout, readTimeout).build()
    }



}
