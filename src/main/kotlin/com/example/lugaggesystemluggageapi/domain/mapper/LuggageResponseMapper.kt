package com.example.lugaggesystemluggageapi.domain.mapper

import com.example.lugaggesystemluggageapi.domain.dto.request.LuggageRequest
import com.example.lugaggesystemluggageapi.domain.model.Luggage
import com.example.lugaggesystemluggageapi.domain.dto.request.response.LuggageResponse
import org.mapstruct.Mapper

@Mapper
interface LuggageResponseMapper {

     fun convertToDto(luggage: Luggage): LuggageResponse
     fun  convertLuggageListToLuggageResponseList(luggages : List<Luggage>): List<LuggageResponse>
     fun convertDtoToEntity(luggageRequest: LuggageRequest):Luggage
}