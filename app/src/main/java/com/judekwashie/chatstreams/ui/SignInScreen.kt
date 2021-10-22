package com.judekwashie.chatstreams.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.judekwashie.chatstreams.R
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.judekwashie.chatstreams.ui.MainDestinations
import com.judekwashie.chatstreams.ui.components.CustomButton
import com.judekwashie.chatstreams.ui.components.CustomTextField
import com.judekwashie.chatstreams.ui.components.NavigationText
import com.judekwashie.chatstreams.ui.components.WelcomeText

@Composable
fun SignInScreen(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .verticalScroll(state = rememberScrollState())
            .fillMaxSize()
    ) {
        WelcomeText()

        CustomTextField(
            hint = stringResource(id = R.string.email),
            marginTop = 56.dp,
            leadingIcon = Icons.Outlined.Email
        )

        CustomTextField(
            hint = stringResource(R.string.password),
            marginTop = 16.dp,
            isPasswordField = true,
            leadingIcon = Icons.Outlined.Lock
        )

        Spacer(modifier = Modifier.height(48.dp))

        CustomButton(
            buttonText = stringResource(id = R.string.sign_in),
            onClick = {
                navController?.navigate(MainDestinations.CHAT_ROUTE){
                    popUpTo(MainDestinations.SIGN_IN_ROUTE){inclusive = true}
                }
            }
        )

        NavigationText(
            infoText = stringResource(id = R.string.dont_have_acc),
            navigationText = stringResource(id = R.string.sign_up),
            onClick = {
                navController?.navigate(MainDestinations.SIGN_UP_ROUTE){
                    popUpTo(MainDestinations.SIGN_IN_ROUTE){inclusive = true}
                }
            }
        )
    }
}

