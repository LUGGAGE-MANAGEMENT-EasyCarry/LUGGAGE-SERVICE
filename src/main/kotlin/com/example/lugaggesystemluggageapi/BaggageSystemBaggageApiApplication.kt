package com.example.lugaggesystemluggageapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class BaggageSystemBaggageApiApplication

fun main(args: Array<String>) {
	runApplication<BaggageSystemBaggageApiApplication>(*args)
}
