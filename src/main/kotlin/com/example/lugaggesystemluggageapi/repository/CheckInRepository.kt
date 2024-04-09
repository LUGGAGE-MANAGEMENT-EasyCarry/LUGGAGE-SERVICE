package com.example.lugaggesystemluggageapi.repository

import com.example.lugaggesystemluggageapi.domain.model.CheckIn
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface CheckInRepository : JpaRepository<CheckIn, UUID> {

}