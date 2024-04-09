package com.example.lugaggesystemluggageapi.repository


import com.example.lugaggesystemluggageapi.domain.model.Luggage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface LuggageRepository : JpaRepository<Luggage, UUID> {


     fun findLuggageByLuggageIdAndCustomerId(customerId: UUID, luggageId: UUID): Luggage

     fun findLuggageByCheckInId(checkInId: UUID): Luggage?

     fun existsByLuggageId(id: UUID): Luggage?

}