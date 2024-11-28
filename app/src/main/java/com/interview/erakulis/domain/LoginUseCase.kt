package com.interview.erakulis.domain

import com.interview.erakulis.data.UserRepository

class LoginUseCase(
    private val userRepository: UserRepository
) {

    suspend fun execute(email: String, password: String): User {
        return userRepository.login(email, password)
    }
}
