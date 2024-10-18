package com.example.practica5

import Screen1
import Screen2
import Screen3
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practica5.ui.theme.Practica5Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var navController = rememberNavController()
            Practica5Theme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color(0xFFCDE7B0)
                            ),
                            title = { Text("Asignaturas") },
                            navigationIcon = {
                                        Icon(
                                            painter = painterResource(R.drawable.back),
                                            contentDescription = "Icono Izquierdo",
                                        )

                            },
                                actions = {
                                        Icon(
                                            imageVector = Icons.Default.AccountCircle,
                                            contentDescription = "Icono Derecho",
                                            tint = Color.Gray,
                                        )
                                }
                        )
                    },

                    bottomBar = {
                        BottomAppBar(
                            containerColor = Color(0xFFCDE7B0)
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            )
                            {
                                Box(
                                    Modifier
                                        .clip(shape = CircleShape)
                                        .height(35.dp)
                                        .width(35.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Home,
                                        contentDescription = "Icono Izquierdo",
                                        tint = Color.Gray,
                                    )
                                }
                                Box(
                                    Modifier
                                        .clip(shape = CircleShape)
                                        .height(35.dp)
                                        .width(35.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.edit),
                                        contentDescription = "Icono Centro",
                                    )
                                }
                                Box(
                                    Modifier
                                        .clip(shape = CircleShape)
                                        .height(35.dp)
                                        .width(35.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.baseline_favorite_24),
                                        contentDescription = "Icono Derecho",
                                        tint = Color.Red,
                                    )
                                }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MyNavControllerCustom(
                        navController = navController,
                        Modifier.padding(innerPadding)
                    )
                    MyLazyColumn(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun MyLazyColumn(modifier: Modifier) {
    val itemList = listOf(
        Asignatura("Historia", R.drawable.history),
        Asignatura("Matematicas", R.drawable.matematicas),
    )
    LazyColumn (modifier = modifier.padding(horizontal = 15.dp).fillMaxWidth()) {
        items(itemList) { asign ->
            Column(Modifier.fillMaxWidth()){
                Text(asign.asignatura,
                    Modifier.align(Alignment.CenterHorizontally))
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                ){
                    Image(
                        painter = painterResource(asign.imageId),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                    )
                }
            }
            Spacer(Modifier.height(20.dp))
        }
    }
}
data class Asignatura(val asignatura: String, val imageId: Int)

@Composable
fun MyNavControllerCustom(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = "screen1",
        modifier = modifier
    ) {
        composable("screen1") { Screen1() }
        composable("screen2") { Screen2() }
        composable("screen3") { Screen3() }
    }
}


