package com.example.feastfinder.ui.theme.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    val backgroundColor = if (loginEnable) Color(0xFFFF4303) else Color(0xFFF78058)

    Button(
        onClick = onLoginSelected,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(CircleShape)
            .background(backgroundColor),
        enabled = loginEnable,
        content = {
            Text(
                text = "Iniciar sesión",
                color = Color.White
            )
        }
    )
}
@Composable
fun MainIconButton(icon: ImageVector, onClick: () -> Unit){
    IconButton(onClick = onClick) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.Black
        )

    }
}
/*
@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color(0xFFFF4303)), // Establecer el color de fondo aquí
        enabled = loginEnable,
        content = {
            Text(text = "Iniciar sesión", color = Color.White)

        }
    )
}*/

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(text = "¿Olvidaste la contraseña?",
        modifier = modifier.clickable {  },
        fontSize = 12.sp, fontWeight = FontWeight.Bold
    )
}

@Composable
fun PasswordFile(password: String, onTextFieldChanged: (String) -> Unit) {
    TextField(value = password, onValueChange = {onTextFieldChanged(it)},
        placeholder = { Text(text= "Contraseña") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1
    )
}


@Composable
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {
    TextField(value = email, onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text= "Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1
    )
}
