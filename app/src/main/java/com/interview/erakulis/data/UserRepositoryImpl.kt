package com.interview.erakulis.data

import com.interview.erakulis.domain.User

class UserRepositoryImpl : UserRepository {

    // Simulated login function with mock response
    override suspend fun login(email: String, password: String): User {
        // Simulating a mocked response for login
        return if (email == "test@example.com" && password == "password123") {
            // Mocked user data on successful login
            User(id = 1, email = email, name = "John Doe", age = 30)
        } else {
            throw Exception("Invalid email or password")
        }
    }

    // Simulated register function with mock response
    override suspend fun registerUser(email: String, password: String, age: Int): User {
        // Simulating a mocked response for registration
        if (age < 18 || age > 99) {
            throw IllegalArgumentException("Age must be between 18 and 99.")
        }

        // If registration is successful, return a mock user object
        return User(id = 1, email = email, name = "New User", age = age)
    }
}
