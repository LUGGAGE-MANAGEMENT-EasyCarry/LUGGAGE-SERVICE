package com.example.lugaggesystemluggageapi.repository


import com.example.lugaggesystemluggageapi.domain.model.Luggage
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface LuggageRepository :CoroutineCrudRepository<Luggage,UUID>{


    fun findLuggageByLuggageIdAndCustomerId(customerId: UUID, luggageId:UUID):Luggage

}