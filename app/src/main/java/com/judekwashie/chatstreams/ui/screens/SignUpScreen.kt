package com.judekwashie.chatstreams.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.judekwashie.chatstreams.R
import com.judekwashie.chatstreams.ui.MainDestinations
import com.judekwashie.chatstreams.ui.screens.components.CustomButton
import com.judekwashie.chatstreams.ui.screens.components.CustomTextField
import com.judekwashie.chatstreams.ui.screens.components.NavigationText
import com.judekwashie.chatstreams.ui.screens.components.WelcomeText

@Composable
fun SignUpScreen(navController: NavController? = null){
    Column(modifier = Modifier
        .verticalScroll(state = rememberScrollState())
        .fillMaxSize()
    ){
        WelcomeText()
        
        CustomTextField(
            hint = stringResource(id = R.string.username),
            marginTop = 56.dp,
            leadingIcon = Icons.Outlined.Person
        )

        CustomTextField(
            hint = stringResource(id = R.string.email),
            marginTop = 16.dp,
            leadingIcon = Icons.Outlined.Email
        )

        CustomTextField(
            hint = stringResource(id = R.string.password),
            marginTop = 16.dp,
            isPasswordField = true,
            leadingIcon = Icons.Outlined.Lock
        )

        Spacer(modifier = Modifier.height(48.dp))

        CustomButton(
            buttonText = stringResource(id = R.string.sign_up),
            onClick = {

            }
        )

        NavigationText(
            infoText = stringResource(id = R.string.already_have_acc),
            navigationText = stringResource(id = R.string.sign_in),
            onClick = {
                navController?.navigate(MainDestinations.SIGN_IN_ROUTE){
                    popUpTo(MainDestinations.SIGN_UP_ROUTE){inclusive = true}
                }
            }
        )

    }
}