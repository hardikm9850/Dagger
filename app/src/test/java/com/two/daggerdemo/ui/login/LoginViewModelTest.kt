package com.two.daggerdemo.ui.login

import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.any

import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import com.nhaarman.mockitokotlin2.verify
import com.two.daggerdemo.network.beans.LoginResponse
import kotlinx.coroutines.flow.flow

@RunWith(MockitoJUnitRunner::class)
class LoginViewModelTest {
   lateinit var viewModel: LoginViewModel

   @Mock
   lateinit var userRepository: UserRepository

   @Mock
   lateinit var messageObserver : Observer<String>

   @Before
   fun setup(){
      MockitoAnnotations.initMocks(this)
      viewModel = LoginViewModel(userRepository)
      viewModel.message.observeForever(messageObserver)
   }

   @Test
   fun `should show error message`(){
      setup()
      whenever(
         userRepository.performLogin(
            any(),
            any()
         )
      ).then { flow<LoginResponse> { LoginResponse("", "") } }
      viewModel.onLoginClicked("","")
      verify(viewModel.message.value).equals("")
      //Mockito.verify(messageObserver).onChanged("")
   }
}