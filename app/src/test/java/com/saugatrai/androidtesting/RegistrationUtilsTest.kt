package com.saugatrai.androidtesting

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilsTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtils().validRegistrationInput(
            "",
            "abc",
            "abc"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtils().validRegistrationInput(
            "ABc",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `existing user returns false`() {
        val result = RegistrationUtils().validRegistrationInput(
            "Carl",
            "987654321",
            "987654321"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password length less than 6 returns false`() {
        val result = RegistrationUtils().validRegistrationInput(
            "Abc",
            "98",
            "98"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password not equal to confirm password returns false`() {
        val result = RegistrationUtils().validRegistrationInput(
            "Abc",
            "98",
            "89"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username password confirm password greater than 6 digits returns true`() {
        val result = RegistrationUtils().validRegistrationInput(
            "John",
            "987654321",
            "987654321"
        )
        assertThat(result).isTrue()
    }

}