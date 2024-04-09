package com.example.lugaggesystemluggageapi.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class CheckIn(
        @Id val id: UUID?=null,var isCheckedIn:Boolean
)
