package com.saugatrai.androidtesting

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class HomeworkTest {

    @Test
    fun `extra braces should return false`() {
        val result = Homework.checkBrace("(x * y))")
        assertThat(result).isFalse()
    }

    @Test
    fun `no extra braces returns true`() {
        val result = Homework.checkBrace("(Hi)")
        assertThat(result).isTrue()
    }

}