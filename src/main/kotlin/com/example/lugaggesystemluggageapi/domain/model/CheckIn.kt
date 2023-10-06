package com.example.lugaggesystemluggageapi.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table(name="checkin")
data class CheckIn(@Id val id: UUID?=null,var isCheckedIn:Boolean)
