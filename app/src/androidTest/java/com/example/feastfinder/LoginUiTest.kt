package com.example.feastfinder.ui.theme.login.ui
import android.util.Patterns
//import com.example.feastfinder.ui.theme.login.ui.isValidLogin
import org.jetbrains.annotations.VisibleForTesting
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LoginUiTest {
    @VisibleForTesting
    internal fun isValidLogin(email: String, password: String): Boolean {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length > 6
        return isEmailValid && isPasswordValid
    }

        @Test
        fun validLogin() {
            val email = "test@example.com"
            val password = "password123"
            assertTrue(isValidLogin(email, password))
        }

        @Test
        fun invalidEmail() {
            val email = "invalid-email"
            val password = "password123"
            assertFalse(isValidLogin(email, password))
        }

        @Test
        fun passwordShorter() {
            val email = "test@example.com"
            val password = "pass"
            assertFalse(isValidLogin(email, password))
        }
}