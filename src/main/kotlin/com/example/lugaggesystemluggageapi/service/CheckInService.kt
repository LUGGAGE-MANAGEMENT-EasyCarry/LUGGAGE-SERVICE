package com.example.lugaggesystemluggageapi.service

import com.example.lugaggesystemluggageapi.domain.dto.request.CheckInRequest
import com.example.lugaggesystemluggageapi.domain.model.CheckIn
import com.example.lugaggesystemluggageapi.repository.CheckInRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CheckInService(private val checkInRepository: CheckInRepository) {

    suspend fun getById(id: UUID): CheckIn? {
        return checkInRepository.findById(id)
    }

    fun create(checkInRequest: CheckInRequest): CheckIn {
        return CheckIn(null, true)
    }

}