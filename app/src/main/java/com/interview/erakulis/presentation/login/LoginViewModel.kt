package com.interview.erakulis.presentation.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.erakulis.domain.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    // LiveData for holding the current state of the login process
    private val _loginState = MutableLiveData<LoginState>()
    val loginState: LiveData<LoginState> = _loginState

    // Form fields as LiveData
    var email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    // Function to handle the login process
    fun login() {
        val emailValue = email.value?.trim()
        val passwordValue = password.value?.trim()

        // Early return if email or password is empty
        if (emailValue.isNullOrEmpty() || passwordValue.isNullOrEmpty()) {
            _loginState.value = LoginState.Error("Email and password must not be empty")
            return
        }

        // Validate email format
        if (!Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()) {
            _loginState.value = LoginState.Error("Invalid email format")
            return
        }

        // Validate password length
        if (passwordValue.length < 6 || passwordValue.length > 12) {
            _loginState.value = LoginState.Error("Password must be between 6 and 12 characters")
            return
        }

        // Show loading state
        _loginState.value = LoginState.Loading

        // Perform the login operation asynchronously using coroutines
        viewModelScope.launch {
            try {
                val result = loginUseCase.execute(emailValue, passwordValue)
                if (result.email.isNullOrEmpty().not()) {
                    // If login is successful
                    _loginState.value = LoginState.Success("Login successful!")
                    // You can trigger navigation or other actions here
                } else {
                    // If login fails
                    _loginState.value = LoginState.Error("Invalid credentials")
                }
            } catch (e: Exception) {
                // Handle any exceptions
                _loginState.value = LoginState.Error("Login failed: ${e.message}")
            }
        }
    }

    // Optional: A function to navigate to the registration screen
    fun navigateToRegister() {
        // Implement your navigation logic here
    }
}
