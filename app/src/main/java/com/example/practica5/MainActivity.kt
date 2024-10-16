package com.example.practica5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica5.ui.theme.Practica5Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica5Theme{
                Scaffold(
                    topBar = {
                            CenterAlignedTopAppBar(
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = Color(0xFFCDE7B0)
                                ),
                                title = { Text("Asignaturas") },
                                navigationIcon = {
                                    Box(Modifier
                                        .clip(shape = CircleShape)
                                        .height(35.dp)
                                        .width(35.dp)
                                        .background(Color.Black)
                                    ){}
                                },
                                actions = {
                                    Box(Modifier
                                        .clip(shape = CircleShape)
                                        .height(35.dp)
                                        .width(35.dp)
                                        .background(Color.Black)
                                    ){}
                                    Box(Modifier
                                        .clip(shape = CircleShape)
                                        .height(35.dp)
                                        .width(35.dp)
                                        .background(Color.Black)
                                    ){}
                                }
                            )
                    },
                    bottomBar = {
                        BottomAppBar(
                            containerColor = Color(0xFFCDE7B0)
                        ) {}
                    },

                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(Modifier.padding(innerPadding)){
                        Text("Texto de ejemplo", Modifier.padding())
                    }
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practica5Theme {
        Greeting("Android")
    }
}


