package com.example.feastfinder.ui.theme.login.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feastfinder.R
import com.example.feastfinder.data.DataSource
import com.example.feastfinder.ui.theme.model.Platillo
import com.example.feastfinder.ui.theme.ui.components.MainIconButton


@Composable
fun MenuApp(navController: NavController) {
    MenuCardList(navController = navController, platilloList = DataSource().loadPlatillos())
}


@Composable
fun MenuCardList(navController: NavController, platilloList: List<Platillo>, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            MenuTopAppBar(navController = navController)
        }
    ) { contentPadding ->
        LazyColumn(contentPadding = contentPadding) {
            items(platilloList) { platillo ->
                MenuCard(
                    platillo = platillo,
                    modifier = modifier.padding(10.dp)
                )
            }
        }
    }
}

@Composable
fun MenuCard(platillo:Platillo, modifier: Modifier = Modifier ){
    Card {
        Column {
            Image(
                painter = painterResource(id = platillo.drawableResourceId),
                contentDescription = stringResource(id = platillo.stringResourceId),
                modifier = modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .clip(CircleShape), // Aplicar forma de círculo al recorte de la imagen
                contentScale = ContentScale.Crop
            )

            Text(
                text = LocalContext.current.getString(platillo.stringResourceId),
                modifier = modifier.padding(22.dp),
                style = MaterialTheme.typography.displayMedium
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.weight(1f).padding(end = 4.dp),

                    ) {
                    Text(text = "Ingredientes")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.weight(1f).padding(start = 4.dp),

                    ) {
                    Text(text = "Receta")
                }
            }

        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopAppBar(modifier: Modifier = Modifier,navController: NavController){
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
        navigationIcon = {
            MainIconButton(icon = Icons.Default.ArrowBack) {
                navController.popBackStack()
            }
        },
        modifier = modifier
    )
}
