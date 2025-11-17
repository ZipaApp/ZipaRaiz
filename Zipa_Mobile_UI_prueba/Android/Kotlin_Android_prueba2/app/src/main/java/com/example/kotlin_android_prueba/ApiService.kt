package com.example.kotlin_android_prueba

import retrofit2.http.GET

data class ProfileResponse(
    val id: Int,
    val name: String,
    val email: String? = null
)

interface ApiService {
    @GET("api/profile")
    suspend fun getProfile(): ProfileResponse
}

