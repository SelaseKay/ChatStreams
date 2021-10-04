package com.judekwashie.chatstreams.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.judekwashie.chatstreams.ui.screens.components.CustomButton
import com.judekwashie.chatstreams.ui.screens.components.CustomTextField
import com.judekwashie.chatstreams.ui.screens.components.NavigationText
import com.judekwashie.chatstreams.ui.screens.components.WelcomeText

@Composable
fun SignInScreen() {
    Column(
        modifier = Modifier
            .verticalScroll(state = rememberScrollState())
            .fillMaxSize()
    ) {
        WelcomeText()

        CustomTextField(
            hint = "Email",
            marginTop = 56.dp,
            leadingIcon = Icons.Outlined.Email
        )

        CustomTextField(
            hint = "Password",
            marginTop = 16.dp,
            isPasswordField = true,
            leadingIcon = Icons.Outlined.Lock
        )

        Spacer(modifier = Modifier.height(48.dp))

        CustomButton(
            buttonText = "SignIn",
            onClick = {

            }
        )

        NavigationText(
            infoText = "Don't have an account? ",
            navigationText = "SignUp"
        )
    }
}

