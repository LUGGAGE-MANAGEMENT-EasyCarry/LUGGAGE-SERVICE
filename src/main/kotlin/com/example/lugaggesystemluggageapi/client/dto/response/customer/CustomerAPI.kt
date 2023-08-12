package com.example.lugaggesystemluggageapi.client.dto.response.customer

import com.example.lugaggesystemluggageapi.client.dto.response.CustomerResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import java.util.UUID

@Component
class CustomerAPI(private val customerClient: WebClient) {

    suspend fun getCustomerById(customerId: UUID): CustomerResponse {
        return customerClient.get().uri {
            it.path("/customers/{id}").build(customerId)
        }.retrieve().awaitBody()
    }

}