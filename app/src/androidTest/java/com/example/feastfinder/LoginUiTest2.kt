package com.example.feastfinder

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.feastfinder.MainActivity
import com.example.feastfinder.ui.theme.login.ui.LoginViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginUiTest2 {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {
        // Obtén el ViewModel de la actividad en la prueba
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        activityScenario.onActivity {
            viewModel = LoginViewModel()
        }
    }

    @Test
    fun testValidLogin() {
        // Ingresa el correo electrónico y contraseña válidos
        composeTestRule.onNodeWithText("Email")
            .performTextInput("correo@example.com")
        composeTestRule.onNodeWithText("Contraseña")
            .performTextInput("password123")

        // Presiona el botón de inicio de sesión
        composeTestRule.onNodeWithText("Iniciar sesión")
            .performClick()

        // Espera a que la carga termine (4 segundos en este caso)
        // Asegúrate de ajustar este tiempo de espera según sea necesario
        Thread.sleep(4000)

        // Verifica que la carga haya finalizado y que no haya errores
        // Aquí podrías verificar que la pantalla de inicio de sesión ha cambiado a otra pantalla,
        // o cualquier otro comportamiento esperado después de un inicio de sesión exitoso.
    }
}

