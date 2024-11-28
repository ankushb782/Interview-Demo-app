package com.interview.erakulis.presentation.utils

class Validator {

    fun isValidEmail(email: String): Boolean {
        return email.contains("@") // Simple email validation; you can make it more complex.
    }

    fun isValidPassword(password: String): Boolean {
        return password.length in 6..12
    }

    fun isValidAge(age: String): Boolean {
        return try {
            val ageInt = age.toInt()
            ageInt in 18..99
        } catch (e: Exception) {
            false
        }
    }
}
