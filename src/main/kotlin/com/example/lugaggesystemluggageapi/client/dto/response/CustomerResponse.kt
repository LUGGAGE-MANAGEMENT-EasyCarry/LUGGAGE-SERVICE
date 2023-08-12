package com.example.lugaggesystemluggageapi.client.dto.response

import java.util.UUID


data class CustomerResponse(
    val id: UUID? =null, val name: String, val password: String, val email: String, var phoneNumber: Int
)