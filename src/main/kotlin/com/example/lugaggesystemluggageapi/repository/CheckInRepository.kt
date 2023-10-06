package com.example.lugaggesystemluggageapi.repository

import com.example.lugaggesystemluggageapi.domain.model.CheckIn
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CheckInRepository :JpaRepository<CheckIn, UUID>{

}