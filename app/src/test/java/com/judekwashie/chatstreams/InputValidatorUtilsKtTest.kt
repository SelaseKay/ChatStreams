package com.judekwashie.chatstreams


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class InputValidatorUtilsKtTest {

    @Test
    fun `empty username, email, password field returns false`() {
        assertThat(isValidateInput()).isFalse()
    }

    @Test
    fun `non-empty username with empty email, password field returns false`() {
        assertThat(isValidateInput("James Kudzo")).isFalse()
    }

    @Test
    fun `password length less than 8 returns false`() {
        assertThat(isValidateInput(password = "23j421")).isFalse()
    }

    @Test
    fun `password length greater than 7 returns true`() {
        assertThat(
            isValidateInput(
                password = "djfae323jlka",
                email = "aewa@g.com",
                username = "Kwame"
            )
        ).isTrue()
    }

    @Test
    fun `valid email address returns true`() {
        assertThat(
            isValidateInput(
                email = "jude@gmail.com",
                password = "asdfeawife2",
                username = "Kudzo"
            )
        ).isTrue()
    }

    @Test
    fun `invalid email address returns false`() {
        assertThat(
            isValidateInput(
                email = "adafe.com",
                password = "aerwa",
                username = "asew"
            )
        ).isFalse()
        assertThat(
            isValidateInput(
                email = "asg@.com",
                password = "afwsdfjoiow3",
                username = "Emefa"
            )
        ).isFalse()
    }
}