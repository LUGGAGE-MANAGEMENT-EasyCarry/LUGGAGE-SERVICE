package com.example.lugaggesystemluggageapi.controller


import com.example.lugaggesystemluggageapi.client.dto.response.customer.CustomerAPI
import com.example.lugaggesystemluggageapi.client.dto.response.notification.NotificationAPI
import com.example.lugaggesystemluggageapi.client.dto.response.notification.dto.NotificationRequest
import com.example.lugaggesystemluggageapi.domain.CustomerAggregate
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
import java.time.LocalDate
import java.util.UUID

@RestController
@RequestMapping("api/v1/luggage")
class LuggageController(private val luggageService: LuggageService, private val notificationAPI: NotificationAPI, private val customerAPI: CustomerAPI) {

    @GetMapping("/luggagebyId")
    suspend fun getLuggageByCustomerIdAndLuggageIdWithState(@RequestParam customerId: UUID, @RequestParam luggageId: UUID): LuggageResponse {

        notificationAPI.create(NotificationRequest(LocalDate.now(), "Çok yakında ! "))
        return luggageService.getLuggageByCustomerIdAndLuggageIdWithState(customerId, luggageId)
    }

    @GetMapping
    suspend fun getLuggages(): List<LuggageResponse> {
        return luggageService.getLuggages()
    }

    @PostMapping
    suspend fun createLuggage(@RequestBody luggageRequest: LuggageRequest): ResponseEntity<LuggageResponse> {
        val createdLuggage = luggageService.createLuggage(luggageRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLuggage)
    }

    @PatchMapping("/{id}")
    suspend fun update(@PathVariable id: UUID, @RequestBody luggageRequest: LuggageRequest): LuggageResponse {
        return luggageService.updateLuggage(id, luggageRequest)
    }

    @PatchMapping("/edit/status/{id}")
    suspend fun updateLuggageForStateInfo(@PathVariable id: UUID, @RequestParam state: String): LuggageResponse {
        return luggageService.updateLuggageForStateInfo(id, state)
    }

    @GetMapping("/luggages/checkInId")
    suspend fun getLuggageByCheckInId(@RequestParam checkInId: UUID): LuggageResponse {
        return luggageService.findCheckInId(checkInId)
    }


    @GetMapping("/luggages/userinfos")
    suspend fun findUsersForCheckedIntoFlight(@RequestParam checkInId: UUID): CustomerAggregate {
        return luggageService.findUsersForCheckedIntoFlight(checkInId)
    }


}