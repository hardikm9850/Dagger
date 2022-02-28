package com.two.daggerdemo.network.beans

data class LoginResponse(val cookie : String, val imgAvatar : String)

data class LoginRequest(val userName : String, val password : String)