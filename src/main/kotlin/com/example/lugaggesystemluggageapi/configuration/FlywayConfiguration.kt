package com.example.lugaggesystemluggageapi.configuration

import org.flywaydb.core.Flyway
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment


@Configuration
class FlywayConfiguration(
private val env: Environment
) {

    @Bean(initMethod = "migrate")

    fun flyway(): Flyway {
        val url = "jdbc:" + env.getRequiredProperty("db.url")
        val user = env.getRequiredProperty("db.user")
        val password = env.getRequiredProperty("db.password")
        val config = Flyway
            .configure()
            .dataSource(url, user, password)
        return Flyway(config)
    }



}
