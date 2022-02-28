package com.two.daggerdemo.di

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.two.daggerdemo.repository.UserRepository
import com.two.daggerdemo.ui.login.LoginViewModel
import com.two.daggerdemo.repository.local.UserLocalDataSource
import com.two.daggerdemo.repository.remote.UserRemoteDataSource
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

    @Provides
    fun provideUserRepository(
        localDataSource: UserLocalDataSource,
        remoteDataSource: UserRemoteDataSource
    ): UserRepository {
        return UserRepository(remoteDataSource, localDataSource)
    }
}