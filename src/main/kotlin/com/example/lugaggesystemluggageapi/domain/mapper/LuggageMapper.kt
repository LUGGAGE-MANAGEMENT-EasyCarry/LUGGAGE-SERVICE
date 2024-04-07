package com.example.lugaggesystemluggageapi.domain.mapper

import com.example.lugaggesystemluggageapi.domain.dto.request.LuggageRequest
import com.example.lugaggesystemluggageapi.domain.model.Luggage
import com.example.lugaggesystemluggageapi.domain.dto.request.response.LuggageResponse
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface LuggageMapper {

    fun toLuggageResponse(luggage: Luggage): LuggageResponse
    fun map(luggages: List<Luggage>): List<LuggageResponse>
    fun toLuggage(luggageRequest: LuggageRequest): Luggage

}