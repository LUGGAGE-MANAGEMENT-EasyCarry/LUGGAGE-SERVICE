package com.example.lugaggesystemluggageapi.model

import com.example.lugaggesystemluggageapi.StateType
import java.util.UUID

data class Luggage(val id : UUID?=null,val weight:Float,val flightId:UUID,val customerID:UUID,val stateType:StateType)
