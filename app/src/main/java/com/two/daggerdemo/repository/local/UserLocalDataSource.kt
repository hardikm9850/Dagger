package com.two.daggerdemo.repository.local

import android.content.SharedPreferences
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(private val sharedPreferences: SharedPreferences) {
    fun saveUserInfo(cookie: String, imageAvatar: String) {
        sharedPreferences.edit().putString(SHARED_PREFS_COOKIE_KEY, cookie).apply()
        sharedPreferences.edit().putString(SHARED_PREFS_IMAGE_AVATAR_KEY, imageAvatar).apply()
    }

    private val SHARED_PREFS_COOKIE_KEY = "cookie"
    private val SHARED_PREFS_IMAGE_AVATAR_KEY = "image_avatar"

}
