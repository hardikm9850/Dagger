package com.two.daggerdemo.network

import com.two.daggerdemo.network.beans.LoginRequest
import com.two.daggerdemo.network.beans.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("login")
    suspend fun performLogin(
        @Body loginRequest: LoginRequest
    ): LoginResponse
}