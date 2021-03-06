package com.saugatrai.androidtesting

class RegistrationUtils {

    private val existingUsers = listOf("Harry", "Peter", "Carl")

    /**
     * false if
     * username is null
     * password is null
     * username already exist
     * password length less than 6 digits
     * confirm password not equal to password
     * */

    fun validRegistrationInput(
        userName: String,
        password: String,
        confirmPassword: String
    ): Boolean {

        if (userName.isEmpty() || password.isEmpty()) return false

        if (userName in existingUsers) return false

        if (password.count { it.isDigit() } < 6) return false

        if (password != confirmPassword) return false

        return true
    }

}