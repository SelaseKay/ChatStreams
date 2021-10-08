package com.judekwashie.chatstreams.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.judekwashie.chatstreams.ui.screens.SignInScreen
import com.judekwashie.chatstreams.ui.screens.SignUpScreen
import com.judekwashie.chatstreams.ui.screens.chat.ChatScreen

object MainDestinations{
    const val SIGN_UP_ROUTE = "signUp"
    const val SIGN_IN_ROUTE = "signIn"
    const val CHAT_ROUTE = "chat"
}

@Composable
fun ChatStreamsNavGraph(
    navController: NavHostController,
    startDestination: String
){
    
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(MainDestinations.SIGN_UP_ROUTE){
            SignUpScreen(navController = navController)
        }
        composable(MainDestinations.SIGN_IN_ROUTE){
            SignInScreen(navController = navController)
        }
        composable(MainDestinations.CHAT_ROUTE){
            ChatScreen()
        }
    }
  
}