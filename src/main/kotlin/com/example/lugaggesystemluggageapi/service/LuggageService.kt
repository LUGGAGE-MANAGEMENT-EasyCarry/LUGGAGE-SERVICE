package com.example.lugaggesystemluggageapi.service

import com.example.lugaggesystemluggageapi.client.dto.response.CustomerResponse
import com.example.lugaggesystemluggageapi.client.dto.response.customer.CustomerAPI
import com.example.lugaggesystemluggageapi.domain.CustomerAggregate
import com.example.lugaggesystemluggageapi.domain.model.Luggage
import com.example.lugaggesystemluggageapi.domain.dto.request.LuggageRequest
import com.example.lugaggesystemluggageapi.domain.dto.request.response.LuggageResponse
import com.example.lugaggesystemluggageapi.domain.event.LuggageCreatedEvent
import com.example.lugaggesystemluggageapi.domain.mapper.LuggageResponseMapper
import com.example.lugaggesystemluggageapi.exception.LuggageNotFoundException
import com.example.lugaggesystemluggageapi.producer.LuggageCreatedEventProducer
import com.example.lugaggesystemluggageapi.repository.LuggageRepository
import kotlinx.coroutines.flow.toList
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam
import java.util.UUID

@Service
class LuggageService(private val luggageRepository: LuggageRepository, private val luggageCreatedEventProducer: LuggageCreatedEventProducer,private val customerService:CustomerAPI) {

    suspend fun getLuggageByCustomerIdAndLuggageIdWithState(customerId: UUID, luggageId: UUID): Luggage {
        return luggageRepository.findLuggageByLuggageIdAndCustomerId(customerId, luggageId)

    }

    suspend fun getLuggages(): List<Luggage> {
        return luggageRepository.findAll().toList()

    }

    suspend fun createLuggage(luggage: Luggage): Luggage {
        val luggageCreated = LuggageCreatedEvent(luggageId = luggage.luggageId, customerId = luggage.customerId)
        luggageCreatedEventProducer.send(luggageCreated)
        return luggageRepository.save(luggage)
    }

    //state a patch mapping yapma ve saveleme- save aynı zamanda update dir
    suspend fun updateLuggage(id: UUID, luggageRequest: LuggageRequest): Luggage {
        val existingLuggage = luggageRepository.findById(id)
        if (existingLuggage == null) {
            throw LuggageNotFoundException("Luggage doesnt found with this id $id")
        } else {
            return luggageRepository.save(existingLuggage)
        }
    }

    suspend fun updateLuggageForStateInfo(id: UUID, stateInfo: String): LuggageResponse {
        val luggage = luggageRepository.findById(id)
        val converter = Mappers.getMapper(LuggageResponseMapper::class.java)
        if (luggage != null) {
            luggage.state = stateInfo
            return converter.convertToDto(luggage)
        }
        throw LuggageNotFoundException("Luggage doesnt found with this id $id")

    }

    suspend fun findCheckInId(checkInId: UUID): LuggageResponse {
        val luggage = luggageRepository.findLuggageByCheckInId(checkInId)
        val converter = Mappers.getMapper(LuggageResponseMapper::class.java)
        if (luggage != null)
            return converter.convertToDto(luggage) else throw RuntimeException("Luggage didnt Found")
    }

    suspend fun findUsersForCheckedIntoFlight(checkInId: UUID): CustomerAggregate {
        val luggage = luggageRepository.findLuggageByCheckInId(checkInId)
        val customer= customerService.getCustomerById(luggage.customerId)
        return CustomerAggregate(customer.name,customer.email,customer.phoneNumber,luggage.weight,luggage.state)
    }
}