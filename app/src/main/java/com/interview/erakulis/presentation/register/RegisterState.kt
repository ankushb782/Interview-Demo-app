package com.interview.erakulis.presentation.register

import com.interview.erakulis.domain.User


sealed class RegisterState {
    object Loading : RegisterState()
    data class Success(val user: User) : RegisterState()
    data class Error(val errorMessage: String) : RegisterState()
}
