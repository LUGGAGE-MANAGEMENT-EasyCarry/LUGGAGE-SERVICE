package com.example.lugaggesystemluggageapi.configuration.client

import com.example.lugaggesystemluggageapi.client.dto.response.customer.CustomerAPI
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


    @Bean("customerApi")
    fun customerApi(customerClient: WebClient) = CustomerAPI(customerClient)

    @Bean
    fun customerAsyncClient(customerApiProperties: CustomerAPIProperties): WebClient {
        return WebClient.builder().baseUrl(customerApiProperties.baseUrl)
            .configureTimeouts(customerApiProperties.readTimeout, customerApiProperties.connectTimeout)
            .build()
    }

    @Bean
    fun customerAsyncApi(customerAsyncClient: WebClient) = CustomerAPI(customerAsyncClient)

}
