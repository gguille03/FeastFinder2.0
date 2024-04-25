package com.example.feastfinder.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.feastfinder.ui.theme.model.AppDatabase
import com.example.feastfinder.ui.theme.model.User
import com.example.feastfinder.ui.theme.model.UserDao
import kotlinx.coroutines.delay
import org.jetbrains.annotations.VisibleForTesting

class LoginViewModel: ViewModel(){

    /* adición de model, esto ya no jalo
    private val userDao: UserDao = AppDatabase.getDatabase(application).userDao()

    suspend fun login(email: String, password: String): User? {
        return userDao.getUserByEmailAndPassword(email, password)
    }
    */
    private val _email = MutableLiveData<String>() // _ por privada
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>() // _ por privada
    val password : LiveData<String> = _password

    private val _loginEnable = MutableLiveData<Boolean>() // _ por privada
    val loginEnable : LiveData<Boolean> = _loginEnable

    private val _isLoading = MutableLiveData<Boolean>() // _ por privada
    val isLoading : LiveData<Boolean> = _isLoading

//PRUEBA LOCAL
    @VisibleForTesting
    internal fun isValidLogin(email: String, password: String): Boolean {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length > 6
        return isEmailValid && isPasswordValid
    }



    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6 //contraseña mayor a 6 caracteres
    private fun isValidEmail(email: String):Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches() //correo válido

    //corrutina
    suspend fun onLoginSelected() {
        _isLoading.value = true
        delay(4000)
        _isLoading.value = false
    }
}
