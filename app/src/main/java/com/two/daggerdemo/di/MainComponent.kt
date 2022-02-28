package com.two.daggerdemo.di

import com.two.daggerdemo.ui.login.LoginActivity
import dagger.Component

@Component(modules = [AppModule::class, ActivityModule::class])
interface MainComponent {
    fun inject(activity: LoginActivity)
}