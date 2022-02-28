package com.two.daggerdemo.repository

import com.two.daggerdemo.network.beans.LoginResponse
import com.two.daggerdemo.repository.local.UserLocalDataSource
import com.two.daggerdemo.repository.remote.UserRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource,
    private val localDataSource: UserLocalDataSource
) {
    fun performLogin(userName: String, password: String): Flow<LoginResponse> {
        return remoteDataSource.validateUser(userName, password)
    }

    fun saveData(cookie: String, avatar: String) {
        localDataSource.saveUserInfo(cookie, avatar)
    }
}