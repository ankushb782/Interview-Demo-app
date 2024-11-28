package com.interview.erakulis.domain

import com.interview.erakulis.data.UserRepository

class RegisterUseCase (
    private val userRepository: UserRepository
) {

    suspend fun execute(email: String, password: String, age: Int): User {
        return userRepository.registerUser(email, password, age)
    }
}
