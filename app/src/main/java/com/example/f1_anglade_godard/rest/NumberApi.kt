package com.example.f1_anglade_godard.rest

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

class NumberApi {

    suspend fun getNumber(n : String) : String {
            val client = HttpClient() {
                install(JsonFeature) {
                    serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    })
                }
            }
            val number: String = client.get("http://numbersapi.com/$n?json")
            return number
    }

}