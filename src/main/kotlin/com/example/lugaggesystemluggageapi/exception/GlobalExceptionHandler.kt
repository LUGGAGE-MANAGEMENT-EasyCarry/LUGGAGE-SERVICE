package com.example.lugaggesystemluggageapi.exception

import com.example.lugaggesystemluggageapi.util.ProblemDetail
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(LuggageNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleLuggageNotFoundException(ex: Exception): ProblemDetail {
        return ProblemDetail(ex.message)
    }

    @ExceptionHandler(LuggageBadRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBadRequestException(ex: Exception): ProblemDetail{
       return ProblemDetail(ex.message)
    }

}