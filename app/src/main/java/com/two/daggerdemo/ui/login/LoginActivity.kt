package com.two.daggerdemo.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.two.daggerdemo.R
import com.two.daggerdemo.car.CarFactory
import com.two.daggerdemo.di.ActivityModule
import com.two.daggerdemo.di.AppModule
import com.two.daggerdemo.di.DaggerMainComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectDagger()
        setupViews()
        setupObserver()
        createCarFactory()
    }

    private fun createCarFactory() {
        val carFactory = CarFactory()
        carFactory.createElectricCar()
        carFactory.createGasCar()
        carFactory.createPetrolCar()
    }

    private fun injectDagger() {
        val appModule = AppModule(applicationContext) // Instantiate App Module
        val activityModule = ActivityModule(this) // Instantiate Activity Module

        val mainComponent = DaggerMainComponent //Component is created
            .builder()
            .activityModule(activityModule) // pass the activity module instance
            .appModule(appModule) //pass the app module instance
            .build()
        mainComponent.inject(this) //We ask the component to inject required objects (viewModel) here
    }

    private fun setupObserver() {
        viewModel.message.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupViews() {
        btnSubmit.setOnClickListener {
            val userName = edt_username.text.toString().trim()
            val password = edit_password.text.toString().trim()
            //Validate fields
            //....
            //Verify user
            viewModel.onLoginClicked(userName, password)
        }
    }
}




