package com.example.lugaggesystemluggageapi.exception


class LuggageNotFoundException(override val message: String? = null) : RuntimeException(message) {
}

class LuggageBadRequestException(override val message: String? = null) : RuntimeException(message) {
}
