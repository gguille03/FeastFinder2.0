package com.example.feastfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.feastfinder.navigation.NavManager
import com.example.feastfinder.ui.theme.theme.FeastFinderTheme
import com.example.feastfinder.ui.theme.login.views.LoginScreen
import com.example.feastfinder.ui.theme.login.views.MenuApp
import com.example.feastfinder.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginViewModel:LoginViewModel by viewModels()
        setContent {
            FeastFinderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavManager(loginViewModel)
                }
            }
        }
    }
}
