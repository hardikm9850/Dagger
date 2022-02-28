package com.two.daggerdemo.repository.remote

import com.two.daggerdemo.network.LoginService
import com.two.daggerdemo.network.beans.LoginRequest
import com.two.daggerdemo.network.beans.LoginResponse
import com.two.daggerdemo.util.flowSingle
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val loginService: LoginService) {

    fun validateUser(userName: String, password: String): Flow<LoginResponse> {
        return flowSingle {
            loginService.performLogin(LoginRequest(userName, password))
        }
    }
}