package com.example.lugaggesystemluggageapi.client.dto.response.notification

data class EmailRequest(val from:String,val to: String,val subject: String,val  htmlContent: String?=null)
