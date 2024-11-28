package com.interview.erakulis.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interview.erakulis.domain.RegisterUseCase
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _registerState = MutableLiveData<RegisterState>()
    val registerState: LiveData<RegisterState> = _registerState

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val age = MutableLiveData<String>()

    // Function to validate the form
    private fun isFormValid(email: String, password: String, age: String): Boolean {
        return email.isNotBlank() && password.length in 6..12 && age.toIntOrNull()?.let { it in 18..99 } == true
    }

    // Register function triggered by the UI
    fun register() {
        val emailValue = email.value.orEmpty()
        val passwordValue = password.value.orEmpty()
        val ageValue = age.value.orEmpty()

        // Validate input
        if (isFormValid(emailValue, passwordValue, ageValue)) {
            _registerState.value = RegisterState.Loading
            viewModelScope.launch {
                try {
                    val ageInt = ageValue.toInt()
                    val user = registerUseCase.execute(emailValue, passwordValue, ageInt)
                    _registerState.value = RegisterState.Success(user)
                } catch (e: Exception) {
                    // Handle any exceptions (e.g., age validation failure, API failure)
                    _registerState.value = RegisterState.Error("Registration failed: ${e.message}")
                }
            }
        } else {
            _registerState.value = RegisterState.Error("Invalid input. Please check your details.")
        }
    }

    // Navigate to login (UI action)
    fun navigateToLogin() {
        // Logic to navigate to login screen
    }
}
