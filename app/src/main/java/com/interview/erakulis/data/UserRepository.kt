package com.interview.erakulis.data

import com.interview.erakulis.domain.User


interface UserRepository {
    suspend fun login(email: String, password: String): User
    suspend fun registerUser(email: String, password: String, age: Int): User
}
