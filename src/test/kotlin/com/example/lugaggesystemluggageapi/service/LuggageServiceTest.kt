/*
package com.example.lugaggesystemluggageapi.service

import com.example.lugaggesystemluggageapi.producer.LuggageCreatedEventProducer
import com.example.lugaggesystemluggageapi.repository.LuggageRepository
import com.example.lugaggesystemluggageapi.utils.createLuggageRequest
import com.example.lugaggesystemluggageapi.utils.getLuggage
import com.example.lugaggesystemluggageapi.utils.getLuggageCreatedEvent
import io.mockk.Runs
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class LuggageServiceTest {
    val luggageRepository = mockk<LuggageRepository>()
    val luggageCreatedEventProducer = mockk<LuggageCreatedEventProducer>()
    private val luggageService = LuggageService(luggageRepository, luggageCreatedEventProducer)


    @BeforeEach
    fun setUp() {
        clearMocks(luggageRepository)
    }

    @Nested
    inner class PostDesign {
        @Test
        fun `when luggageService#createLuggage it should return Luggage `() = runBlocking {
            //given
            val luggageToSave = createLuggageRequest()
            val luggageCreatedEvent = getLuggageCreatedEvent()
            val expected = getLuggage()
            coEvery { luggageRepository.save(luggageToSave) } returns expected
            coEvery { luggageCreatedEventProducer.send(luggageCreatedEvent) } just Runs
            val actual = luggageService.createLuggage(luggageToSave)
            assertEquals(actual, expected)
            coVerify {
                luggageRepository.save(luggageToSave)
                luggageCreatedEventProducer.send(luggageCreatedEvent)
            }
        }
    }

    @Nested
    inner class GetDesign {
        @Test
        fun `when luggageService#createLuggage it should return Luggage `() = runBlocking {
            val expected = getLuggage()
            coEvery { luggageRepository.findAll() } returns flowOf(expected)
            val actual = luggageService.getLuggages()
            assertEquals(expected, actual)
            coVerify {
                luggageRepository.findAll()
            }
        }

        @Test
        fun `when luggageService#getLuggages  is null it should throw Exception `() = runBlocking {
            coEvery {
                luggageRepository.findAll()
            } throws RuntimeException()
            assertThrows<RuntimeException> {
                luggageService.getLuggages()
            }

            coVerify { luggageRepository.findAll() }
        }
        // I have an problem with Kotlin Flow
    }


}*/
