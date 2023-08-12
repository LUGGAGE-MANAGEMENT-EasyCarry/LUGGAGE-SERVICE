package com.example.lugaggesystemluggageapi.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.time.Duration

@ConstructorBinding
@ConfigurationProperties("luggage-system.customer-api")
data class CustomerAPIProperties(val baseUrl: String,
                                 val connectTimeout: Duration,
                                 val readTimeout: Duration
)