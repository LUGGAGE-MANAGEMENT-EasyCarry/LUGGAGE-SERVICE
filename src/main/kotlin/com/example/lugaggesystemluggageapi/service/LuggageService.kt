package com.example.lugaggesystemluggageapi.service

import com.example.lugaggesystemluggageapi.domain.dto.request.LuggageRequest
import com.example.lugaggesystemluggageapi.domain.dto.request.response.LuggageResponse
import com.example.lugaggesystemluggageapi.domain.mapper.LuggageMapper
import com.example.lugaggesystemluggageapi.exception.LuggageNotFoundException
import com.example.lugaggesystemluggageapi.repository.LuggageRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class LuggageService(
        private val repo: LuggageRepository,
        private val mapper: LuggageMapper
) {

     fun getLuggageByCustomerIdAndLuggageIdWithState(customerId: UUID, luggageId: UUID): LuggageResponse {
        val luggage = repo.findLuggageByLuggageIdAndCustomerId(customerId, luggageId)
        return mapper.toLuggageResponse(luggage)
    }

     fun getLuggages(): List<LuggageResponse> {
        val luggages = repo.findAll()
        return mapper.map(luggages)
    }

     fun createLuggage(luggageRequest: LuggageRequest): LuggageResponse {
        val luggage = mapper.toLuggage(luggageRequest)
        val createdLuggage = repo.save(luggage)
        return mapper.toLuggageResponse(createdLuggage)
    }

     fun updateLuggage(id: UUID, luggageRequest: LuggageRequest): LuggageResponse {
        val existingLuggage = repo.existsByLuggageId(id)

        val updatedLuggage = existingLuggage?.let { repo.save(it) }
                ?: throw LuggageNotFoundException("Luggage doesnt found with this id $id")
        return  mapper.toLuggageResponse(updatedLuggage)
    }

    fun updateLuggageForStateInfo(id: UUID, stateInfo: String): LuggageResponse {
        val luggage = repo.findById(id).orElseThrow()
        luggage?.let { it.state = stateInfo } ?: throw LuggageNotFoundException("Luggage doesnt found with this id $id")
        repo.save(luggage)
        return mapper.toLuggageResponse(luggage)
    }

     fun findCheckInId(checkInId: UUID): LuggageResponse {
        val luggage = repo.findLuggageByCheckInId(checkInId)
        return  luggage?.let { mapper.toLuggageResponse(luggage) } ?: throw RuntimeException("Luggage didnt Found")
    }

}