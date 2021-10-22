package com.judekwashie.chatstreams

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.judekwashie.chatstreams.ui.ChatStreamsNavGraph
import com.judekwashie.chatstreams.ui.MainDestinations
import com.judekwashie.chatstreams.ui.SignInScreen
import com.judekwashie.chatstreams.ui.SignUpScreen
import com.judekwashie.chatstreams.ui.theme.ChatStreamsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChatStreamsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    ChatStreamsNavGraph(
                        navController = navController,
                        startDestination = MainDestinations.SIGN_IN_ROUTE
                    )
                }
            }
        }
    }

    @Preview
    @Composable
    fun SignInPreview(){
        ChatStreamsTheme {
            // A surface container using the 'background' color from the theme
            Surface(modifier = Modifier.fillMaxSize(),color = MaterialTheme.colors.background) {
                SignInScreen()
            }
        }
    }

    @Preview
    @Composable
    fun SignUpPreview(){
        ChatStreamsTheme {
            // A surface container using the 'background' color from the theme
            Surface(modifier = Modifier.fillMaxSize(),color = MaterialTheme.colors.background) {
                SignUpScreen()
            }
        }
    }
}