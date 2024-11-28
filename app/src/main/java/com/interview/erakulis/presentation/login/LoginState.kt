package com.interview.erakulis.presentation.login

sealed class LoginState {
    object Loading : LoginState()
    data class Success(val message: String) : LoginState()
    data class Error(val message: String) : LoginState()
}
