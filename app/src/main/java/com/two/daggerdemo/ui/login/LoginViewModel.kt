package com.two.daggerdemo.ui.login

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import com.two.daggerdemo.network.beans.LoginResponse
import com.two.daggerdemo.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class LoginViewModel(
    private val userRepository: UserRepository
) : ViewModel(), LifecycleObserver {

    val message = MutableLiveData<String>()

    fun onLoginClicked(userName : String, password : String){
        userRepository.performLogin(userName,password)
            .onCompletion {
                Log.d(LoginViewModel::class.simpleName,"onCompletion")
            }
            .onEach {  loginResponse ->
                message.postValue("Success !!")
                saveUserDetails(loginResponse)
            }
            .catch {
                Log.e(LoginViewModel::class.simpleName, "Failed to receive response", it)
                message.postValue("Invalid credentials, please try again")
            }
            .launchIn(viewModelScope)
    }

    private fun saveUserDetails(loginResponse: LoginResponse) {
        Log.d(LoginViewModel::class.simpleName,"$loginResponse")
        userRepository.saveData(loginResponse.cookie,loginResponse.imgAvatar)
    }


    class ViewModelFactory(
        owner: SavedStateRegistryOwner,
        private val userRepository: UserRepository,
        defaultArgs: Bundle? = null
    ) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
        override fun <T : ViewModel> create(
            key: String, modelClass: Class<T>, handle: SavedStateHandle
        ): T {
            return LoginViewModel(
                userRepository
            ) as T
        }
    }

}