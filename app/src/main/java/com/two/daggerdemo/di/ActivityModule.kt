package com.two.daggerdemo.di

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.two.daggerdemo.ui.login.LoginViewModel
import com.two.daggerdemo.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: ComponentActivity) {
    @Provides
    fun provideMyViewModel(userRepository: UserRepository):
            LoginViewModel {
        return ViewModelProvider(
            activity.viewModelStore,
            LoginViewModel.ViewModelFactory(activity, userRepository, activity.intent.extras)
        )[LoginViewModel::class.java]
    }
}