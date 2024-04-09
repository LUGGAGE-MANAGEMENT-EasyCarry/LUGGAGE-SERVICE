package com.example.lugaggesystemluggageapi.controller


import com.example.lugaggesystemluggageapi.domain.dto.request.LuggageRequest
import com.example.lugaggesystemluggageapi.domain.dto.request.response.LuggageResponse
import com.example.lugaggesystemluggageapi.service.LuggageService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/v1/luggage")
class LuggageController(private val luggageService: LuggageService) {

    @GetMapping("/luggagebyId")
     fun getLuggageByCustomerIdAndLuggageIdWithState(@RequestParam customerId: UUID, @RequestParam luggageId: UUID): LuggageResponse {
        return luggageService.getLuggageByCustomerIdAndLuggageIdWithState(customerId, luggageId)
    }

    @GetMapping
     fun getLuggages(): List<LuggageResponse> {
        return luggageService.getLuggages()
    }

    @PostMapping
     fun createLuggage(@RequestBody luggageRequest: LuggageRequest): ResponseEntity<LuggageResponse> {
        val createdLuggage = luggageService.createLuggage(luggageRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLuggage)
    }

    @PatchMapping("/{id}")
     fun update(@PathVariable id: UUID, @RequestBody luggageRequest: LuggageRequest): LuggageResponse {
        return luggageService.updateLuggage(id, luggageRequest)
    }

    @PatchMapping("/edit/status/{id}")
     fun updateLuggageForStateInfo(@PathVariable id: UUID, @RequestParam state: String): LuggageResponse {
        return luggageService.updateLuggageForStateInfo(id, state)
    }

    @GetMapping("/luggages/checkInId")
     fun getLuggageByCheckInId(@RequestParam checkInId: UUID): LuggageResponse {
        return luggageService.findCheckInId(checkInId)
    }


}