package com.example.feastfinder.ui.theme.login.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feastfinder.R
import com.example.feastfinder.ui.theme.ui.components.EmailField
import com.example.feastfinder.ui.theme.ui.components.ForgotPassword
import com.example.feastfinder.ui.theme.ui.components.LoginButton
import com.example.feastfinder.ui.theme.ui.components.PasswordFile
import com.example.feastfinder.viewmodel.LoginViewModel
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            FeastFinderAppBar()
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            item {
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Login(
                        modifier = Modifier.align(Alignment.Center),
                        viewModel = viewModel,
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel, navController: NavController) {

    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()

    if (isLoading) {
        Box(Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    } else {
        Column(modifier = modifier) {
            HeaderImage(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            EmailField(email, { viewModel.onLoginChange(it, password) })
            Spacer(modifier = Modifier.padding(4.dp))
            PasswordFile(password) { viewModel.onLoginChange(email, it) }
            Spacer(modifier = Modifier.padding(8.dp))
            ForgotPassword(Modifier.align(Alignment.End))
            Spacer(modifier = Modifier.padding(16.dp))
            LoginButton(loginEnable) {
                coroutineScope.launch {
                    viewModel.onLoginSelected()
                    navController.navigate("Recetas")
                }
            }
        }
    }
}


@Composable
fun HeaderImage(modifier:Modifier) {
    Image(painter = painterResource(id = R.drawable.cocina),
        contentDescription = "head",
        modifier= modifier)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeastFinderAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){

                Image(painter = painterResource(id = R.drawable.app_feastfinder),
                    contentDescription = null,
                    modifier = modifier
                        .padding(8.dp)
                        .size(64.dp)

                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )

            }


        },
        modifier = modifier
    )
}